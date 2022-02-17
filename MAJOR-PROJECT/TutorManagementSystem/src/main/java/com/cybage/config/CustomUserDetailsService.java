package com.cybage.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.dto.UserDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.UserDao;
import com.cybage.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;

		UserDao user = userDao.findByEmail(email);
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole().toString()));
			return new User(user.getEmail(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + email);
	}

	public UserDao save(UserDTO user) {
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setStatus(ApprovalStatus.APPROVED);
		newUser.setCreatedon(LocalDateTime.now());
		return userDao.save(newUser);
	}

	public UserDao loadUser(String email) {
		return userDao.findByEmail(email);
	}

	public boolean checkEmail(String email) {
		UserDao user = userDao.findByEmail(email);
		return user!=null;
	}

}
