package com.appointment.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.entities.Appointment;

import com.appointment.entities.User;
import com.appointment.*; 


public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{
	
	List<Appointment> findByUser(User user);

}
