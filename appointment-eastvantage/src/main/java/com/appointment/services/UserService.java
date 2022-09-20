package com.appointment.services;

import java.util.List;

import com.appointment.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	void deleteUser(Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	UserDto updateUser(Integer userId, UserDto userDto);

}
