package com.mono.common.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(length = 150 , nullable = false, unique = true)
	private String email;
	
	@Column(length = 64 , nullable = false)
	private String password;
	
	@Column(length = 50 , nullable = false)
	private String firstName;
	
	@Column(length = 50, nullable = false )
	private String lastName;
	
	@Column(length = 150 )
	private String image;
	
	private Boolean enabled;
	
	@ManyToAny(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name= "role_id")
			)
	private Set<Role> userRoles = new HashSet<>();
	
	public User() {
		
	}
	
	
	
	public User(String email, String password,
			String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public Set<Role> getUserRoles() {
		return userRoles;
	}



	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}



	//	this method TO add a role to the user
	public void addUserRole(Role role) {
		this.userRoles.add(role);
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userRoles=" + userRoles + "]";
	}
	
	
	
}
