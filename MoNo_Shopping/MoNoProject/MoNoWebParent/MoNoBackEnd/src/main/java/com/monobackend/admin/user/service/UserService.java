package com.monobackend.admin.user.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mono.common.entity.User;
import com.monobackend.admin.mapper.UserMapper;
import com.monobackend.admin.user.dto.UserDto;
import com.monobackend.admin.user.repo.UserRepo;

@Service
public class UserService {

	private UserMapper userMapper = 
				Mappers.getMapper(UserMapper.class);
	
	@Autowired
	private UserRepo userRepo ;
	
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		List<User> users = userRepo.findAll();
		
		return new ResponseEntity<>(userMapper.toUserDtos(users),
				HttpStatus.OK) ;
	}
	
}
