package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.config.CustomUserDetailsService;
import com.cybage.config.JwtUtil;
import com.cybage.dto.UserDTO;
import com.cybage.model.AuthenticationRequest;
import com.cybage.model.AuthenticationResponse;
import com.cybage.model.UserDao;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
				authenticationRequest.getPassword()));

		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		String token = jwtUtil.generateToken(userdetails);
		UserDao user = userDetailsService.loadUser(authenticationRequest.getEmail());
		if (user != null) {
			AuthenticationResponse newUser = new AuthenticationResponse(token, user.getId(), user.getUsername(),
					user.getRole().toString(), user.getStatus());
			return new ResponseEntity<>(newUser,HttpStatus.OK);
		} else
			return new ResponseEntity<>(new AuthenticationResponse(),HttpStatus.NOT_FOUND);
	}

	@PostMapping("/register")
	public ResponseEntity<UserDao> saveUser(@RequestBody UserDTO user) {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@PostMapping(value="/checkemail")
	public Boolean checkEmail(@RequestBody AuthenticationRequest request){
		return userDetailsService.checkEmail(request.getEmail());
	}
}
