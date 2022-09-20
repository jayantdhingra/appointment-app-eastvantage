package com.appointment.controller;

import com.appointment.config.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.exceptions.ApiResponse;
import com.appointment.payloads.AppointmentDto;
import com.appointment.services.AppointmentService;


@RestController
@RequestMapping("/api/")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	
	//Create Appointment
	@PostMapping("/user/{userId}/appointments")
	public ResponseEntity<AppointmentDto> createAppt(@Valid @RequestBody AppointmentDto appointmentDto,
			@PathVariable Integer userId){
		
		AppointmentDto createAppointment = this.appointmentService.createAppt(appointmentDto, userId);
		
		return new ResponseEntity<AppointmentDto>(createAppointment, HttpStatus.CREATED);
	}
	
	//Delete Appointment
	
	@DeleteMapping("/appointments/{appId}")
	public ResponseEntity<ApiResponse> deleteAppt(@PathVariable Integer appId){
		this.appointmentService.deleteAppt(appId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Appointment has been deleted Successfully", true),HttpStatus.OK);
	}
	
	
	// Update Appointment
	@PutMapping("/appointments/{appId}")
	public ResponseEntity<AppointmentDto> updateAppt(@RequestBody AppointmentDto appointmentDto,
			@PathVariable Integer appId){
		
		AppointmentDto updateAppt = this.appointmentService.updateAppt(appointmentDto, appId);
		
		
		return new ResponseEntity<AppointmentDto>(updateAppt, HttpStatus.OK);
		
	}
	
	
	//Get Appointment By ID
	
	@GetMapping("/appointments/{appId}")
	public ResponseEntity<AppointmentDto> getById(@PathVariable Integer appId){
		
		AppointmentDto get = this.appointmentService.getApptById(appId);
		
		return new ResponseEntity<AppointmentDto>(get, HttpStatus.OK);

	}
	
	//Get ALL Appointments
	
	@GetMapping("/appointments")
	public ResponseEntity<List<AppointmentDto>> getAll(
			@RequestParam(value="pageNumber", defaultValue=AppConstants.PAGE_NUMBER,required=false) Integer pageNumber,
			@RequestParam(value="pageSize", defaultValue= AppConstants.PAGE_SIZE, required=false) Integer pageSize,
			@RequestParam(value="sortByDate", defaultValue=AppConstants.SORT_BY_DATE, required=false) String sortByDate
			){
		
		List<AppointmentDto> getAllDto = this.appointmentService.getAllAppt(pageNumber, pageSize, sortByDate);
		
		return new ResponseEntity<List<AppointmentDto>>(getAllDto, HttpStatus.OK);
	}
	

}





















































