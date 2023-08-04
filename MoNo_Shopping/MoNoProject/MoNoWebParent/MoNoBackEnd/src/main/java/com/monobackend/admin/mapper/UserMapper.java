package com.monobackend.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mono.common.entity.User;
import com.monobackend.admin.user.dto.UserDto;

@Mapper(
	    componentModel = "spring"
	)
public interface UserMapper {
	
	UserDto toUserDto (User user);
	
	List<UserDto> toUserDtos (List<User> users);
	
	User toUser (UserDto userDto);
}
