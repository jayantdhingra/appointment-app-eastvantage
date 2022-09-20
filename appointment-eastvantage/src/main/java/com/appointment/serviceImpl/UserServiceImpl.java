package com.appointment.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.entities.User;
import com.appointment.exceptions.ResourceNotFoundException;
import com.appointment.payloads.UserDto;
import com.appointment.repo.UserRepo;
import com.appointment.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User users = this.modelMapper.map(userDto, User.class);
		
		User addedUser = this.userRepo.save(users);
		
		
				
		return this.modelMapper.map(addedUser, UserDto.class);
	}

	
	
	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		
		this.userRepo.delete(user);
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDto = 
				users
				.stream()
				.map((user) -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		
		
		return userDto;
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		
		
		
		
		return this.modelMapper.map(user, UserDto.class);
	}

}
