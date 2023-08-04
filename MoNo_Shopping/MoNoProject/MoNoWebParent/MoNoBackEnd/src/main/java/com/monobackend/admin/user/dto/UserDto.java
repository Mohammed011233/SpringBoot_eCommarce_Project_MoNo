package com.monobackend.admin.user.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mono.common.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	@JsonProperty("userId")
	private Long userId;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("userRoles")
	private Set<Role> userRoles = new HashSet<>();
	
}
