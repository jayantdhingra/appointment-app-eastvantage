package com.appointment.payloads;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.appointment.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDto {
	
	private int appId;
	
	@NotEmpty
	@Size(min=5)
	private String purpose;
	
	@NotEmpty
	private LocalDate date;
	
//	@NotEmpty
//	private LocalTime time;
	
	@NotEmpty
	private int duration;
	
	private User user;

}
