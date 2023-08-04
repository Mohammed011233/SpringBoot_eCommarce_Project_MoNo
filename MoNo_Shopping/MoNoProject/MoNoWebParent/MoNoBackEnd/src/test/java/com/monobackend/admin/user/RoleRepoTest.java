package com.monobackend.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.mono.common.entity.Role;
import com.monobackend.admin.user.repo.RoleRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepoTest {

	@Autowired
	private RoleRepo roleRepo ;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("admin" , "manage everything");
		Role savedRole = roleRepo.save(roleAdmin);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateAllRoles() {
		Role roleSalesperson = new Role("Salesperson", "manage product price, Customers,"
				+ "shipping, orders and sales report");
		
		Role roleEditor = new Role("Editor", "manage Categories, brands,"
				+ "products, articles and menus");
		
		Role roleShipper = new Role("Shipper", "manage view products, view orders,"
				+ "and update order status");
		
		Role roleAssistant = new Role("Assistant", "manage Questions and reviews");
		
		roleRepo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
	}
}
