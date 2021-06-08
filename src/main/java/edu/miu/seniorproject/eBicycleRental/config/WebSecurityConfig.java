package edu.miu.seniorproject.eBicycleRental.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.miu.seniorproject.eBicycleRental.serviceimplementation.BicyclerentalUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    public WebSecurityConfig(BicyclerentalUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**", "/images/**", "/css/**", "/ebicyclerental/public/**").permitAll()
//                .antMatchers("/", "/ebicyclerental/public/search/results").permitAll()
                .antMatchers("/ebicyclerental/secured/admin/**", "/resources/secured/admin/**", "/ebicyclerental/admin/**", "/admin/**").hasRole("ADMIN")
                .antMatchers("/ebicyclerental/secured/staff/**", "/resources/secured/staff/**","/staff/**").hasRole("STAFF")
                .antMatchers("/ebicyclerental/secured/customer/**", "/resources/secured/customer/**","/ebicyclerental/customer/**").hasRole("CUSTOMER")
//                .antMatchers("/ebicyclerental/public/search/result/**").hasRole("CUSTOMER")
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/ebicyclerental/public/home/login")
                .defaultSuccessUrl("/ebicyclerental/secured/home")
                .failureUrl("/ebicyclerental/public/home/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/ebicyclerental/public/home/logout"))
                .logoutSuccessUrl("/ebicyclerental/public/home/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }
}
