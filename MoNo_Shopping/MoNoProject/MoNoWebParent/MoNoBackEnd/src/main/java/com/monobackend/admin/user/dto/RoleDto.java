package com.monobackend.admin.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoleDto {
	
	@JsonProperty("roleId")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
}
