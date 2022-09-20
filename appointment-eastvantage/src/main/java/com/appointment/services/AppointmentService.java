package com.appointment.services;

import java.util.List;

import com.appointment.payloads.AppointmentDto;

public interface AppointmentService {
	
	//Create
	AppointmentDto createAppt(AppointmentDto appointmentDto, Integer userId);
	
	
	//Delete
	
	void deleteAppt(Integer appId);
	
	// Update
	
	AppointmentDto updateAppt(AppointmentDto appointmentDto, Integer appId);
	
	//get by ID
	
	AppointmentDto getApptById(Integer appId);
	
	//Get ALL
	
	List<AppointmentDto> getAllAppt(Integer pageNumber, Integer pageSize, String sortByDate);
	
	// GetAll By USer
	
	List<AppointmentDto> getApptByUser(Integer userId);

}
