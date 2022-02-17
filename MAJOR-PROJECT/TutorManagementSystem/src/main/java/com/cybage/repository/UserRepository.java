package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.UserDao;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer>{

	public UserDao findByEmailAndPassword(String email,String password);
	
	public UserDao findByEmail(String email);

	public UserDao findByUsername(String email);
	

}
