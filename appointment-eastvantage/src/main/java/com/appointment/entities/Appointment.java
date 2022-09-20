package com.appointment.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="appointment")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appId;
	
	private String purpose;
	
	@Column(name="scheduled_date", nullable=false)
	private LocalDate date;
	
//	@Column(name="scheduled_time", nullable=false)
//	private LocalTime time;
	
	private int duration;
	
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	


}
