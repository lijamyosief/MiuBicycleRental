package edu.miu.seniorproject.eBicycleRental.serviceimplementation;

import edu.miu.seniorproject.eBicycleRental.model.Credential;
import edu.miu.seniorproject.eBicycleRental.model.Role;
import edu.miu.seniorproject.eBicycleRental.model.User;
import edu.miu.seniorproject.eBicycleRental.repository.IUserRepository;
import edu.miu.seniorproject.eBicycleRental.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {
	@Autowired
	private IUserRepository userRepository;
	

	public UserServiceImp(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getCredential().getPassword());
		user.getCredential().setPassword(encodedPassword);
		Role role=new Role();
		role.setRoleName("ROLE_CUSTOMER");
		user.setRoles(Arrays.asList(role));
		return userRepository.save(user);
	}

	@Override
	public User findById(Long uId) {
		return userRepository.findById(uId).orElse(null);
	}

	@Override
	public void delete(Long uId) {
		userRepository.deleteById(uId);
	}

	@Override
	public User findByCredential(Credential credential) {
		return userRepository.findByCredential(credential);
	}

}
