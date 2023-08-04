package com.monobackend.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mono.common.entity.Role;
import com.mono.common.entity.User;
import com.monobackend.admin.user.repo.UserRepo;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TestEntityManager entityManager; 
	
	@Test
	public void testCreateNewUserWithOneRole() {
//		this statement to get the real role from DB that is have id = 8 (Admin role) 
//		by TestEntityManager object 
		Role adminRole = entityManager.find(Role.class, 8);
		
		User newUser = new User("mohamed.a.nossir@gmail.com", "1234", "Mohamed", "Ali");
		
		newUser.addUserRole(adminRole);
		
		User savedUser = userRepo.save(newUser);
		
		assertThat(savedUser.getUserId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithManyRoles() { 
		User newUser = new User("mohamed@gmail.com", "1234", "Mohamed", "Nossir");
		Role editorRole = new Role();
		editorRole.setId(10);
		
		Role shipperRole = new Role();
		shipperRole.setId(11);

		
		newUser.addUserRole(editorRole);
		newUser.addUserRole(shipperRole);
		
		User savedUser = userRepo.save(newUser);
		assertThat(savedUser.getUserId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		List<User> allUsers = userRepo.findAll();
		allUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User foundUser = userRepo.findById((long) 7).get();
		System.out.println(foundUser);
		assertThat(foundUser).isNotNull();
	}
	
	@Test
	public void testUpdateUser() {
		User foundUser = userRepo.findById((long) 7).get();
		foundUser.setEmail("Mohamed.javaProgrammer@gmail.com");
		foundUser.setEnabled(true);
		
		userRepo.save(foundUser);
	}
	
	@Test
	public void testUpdateUserRoles() {
		User foundUser = userRepo.findById((long) 7).get();
		
//		To remove a role from the userRoles set 
//			must get a role object that is have all data ( id, name and description) 	
		Role shipperRole = entityManager.find(Role.class, 11);
		foundUser.getUserRoles().remove(shipperRole);

		//But when add a new role to the userRoles set 
//			just have the id of role because the join table
		Role salespersonRole = new Role(9);
		foundUser.addUserRole(salespersonRole);
		
		
		foundUser.getUserRoles().forEach(role -> System.out.println(role));
		
		userRepo.save(foundUser);
	}
	
	@Test
	public void testDeletUser() {
		userRepo.deleteById((long) 7);
	}

}
