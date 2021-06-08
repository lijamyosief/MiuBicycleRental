package edu.miu.seniorproject.eBicycleRental.serviceimplementation;

import edu.miu.seniorproject.eBicycleRental.model.Credential;
import edu.miu.seniorproject.eBicycleRental.repository.ICredentialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class BicyclerentalUserDetailsService implements UserDetailsService {

    @Autowired
    private ICredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential user = credentialRepository.findByUserName(username)
                     .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
               getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Credential user) {
        System.out.println("++++++++++"+user.getUserName());
        //System.out.println("++++++++++"+user.getUser());


        String[] userRoles = user.getUser().getRoles().stream().map((role) -> role.getRoleName()).toArray(String[]::new);
        System.out.println("++++++++++"+userRoles[0]);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

}
