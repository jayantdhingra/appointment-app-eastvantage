package com.appointment.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	
	@NotEmpty
	@Size(min=3, message="Username must be of 3 characher")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=3, max=15, message = "password must be min of 3 chars and max of 10 chars !!")
	private String password;

}
