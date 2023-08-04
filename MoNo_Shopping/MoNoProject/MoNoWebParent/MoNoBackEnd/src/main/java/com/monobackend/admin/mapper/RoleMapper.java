package com.monobackend.admin.mapper;

import org.mapstruct.Mapper;

import com.mono.common.entity.Role;
import com.monobackend.admin.user.dto.RoleDto;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	
	RoleDto toRoleDto (Role Role);
	
	Role toRole (RoleDto roleDto);
	
}
