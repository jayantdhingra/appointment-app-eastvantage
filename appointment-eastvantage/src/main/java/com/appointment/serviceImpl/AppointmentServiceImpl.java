package com.appointment.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.appointment.entities.Appointment;
import com.appointment.entities.User;
import com.appointment.exceptions.ResourceNotFoundException;
import com.appointment.payloads.AppointmentDto;
import com.appointment.repo.AppointmentRepo;
import com.appointment.repo.UserRepo;
import com.appointment.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	
	//CREATE APPOINTMENT

	@Override
	public AppointmentDto createAppt(AppointmentDto appointmentDto, Integer userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","User ID",userId));
		
		Appointment appt = this.modelMapper.map(appointmentDto, Appointment.class);
		
		appt.setUser(user);
		
		
		Appointment updatedAppt = this.appointmentRepo.save(appt);
		
		return this.modelMapper.map(updatedAppt, AppointmentDto.class);
	}
	
	
	//DELETE APPOINTMENT

	@Override
	public void deleteAppt(Integer appId) {
		Appointment appt = this.appointmentRepo.findById(appId)
				.orElseThrow(()-> new ResourceNotFoundException("Appointment","Appointment ID",appId));
		
		this.appointmentRepo.delete(appt);

	}
	
	
	
	//UPDATE 

	@Override
	public AppointmentDto updateAppt(AppointmentDto appointmentDto, Integer appId) {
		
		Appointment app = this.appointmentRepo.findById(appId)
				.orElseThrow(()-> new ResourceNotFoundException("Appointment","Appointment ID",appId));
		
		app.setDate(appointmentDto.getDate());
		app.setDuration(appointmentDto.getDuration());
		app.setPurpose(appointmentDto.getPurpose());
//		app.setTime(appointmentDto.getTime());
		
		
		Appointment updatedApp = this.appointmentRepo.save(app);
		
		return this.modelMapper.map(updatedApp, AppointmentDto.class);
	}
	

	//GETTING APPOINTMENT BY ID

	@Override
	public AppointmentDto getApptById(Integer appId) {
		
		Appointment appt = this.appointmentRepo.findById(appId)
				.orElseThrow(()-> new ResourceNotFoundException("Appointment","Appointment ID",appId));
		
		return this.modelMapper.map(appt, AppointmentDto.class);
	}
	
	//Get ALL Appointments

	@Override
	public List<AppointmentDto> getAllAppt(Integer pageNumber, Integer pageSize, String sortByDate) {
		
		
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortByDate));
		Page<Appointment> pageAppointment = this.appointmentRepo.findAll(p);
		
		
		List<Appointment> allAppointments = pageAppointment.getContent();
	
		
		List<AppointmentDto> apptDto = 
				allAppointments
				.stream()
				.map((appointment)-> this.modelMapper.map(appointment, AppointmentDto.class))
				.collect(Collectors.toList());
		
		
		
		return apptDto;
	}

	
	//Getting Appointment By User
	
	@Override
	public List<AppointmentDto> getApptByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","User ID",userId));
		
		
		List<Appointment> appt = this.appointmentRepo.findByUser(user);
		
		List<AppointmentDto> apptDto = 
				appt
				.stream()
				.map((appointment) -> this.modelMapper.map(appointment, AppointmentDto.class))
				.collect(Collectors.toList());
		
		
		
		return apptDto;
	}

}









































