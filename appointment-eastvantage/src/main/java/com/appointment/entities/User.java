package com.appointment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	
	@Column(name="username", nullable=false, length =100)
	private String name;
	
	private String email;
	
	private String password;
	
	
	@OneToMany(mappedBy="user",  cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Appointment> appointments = new ArrayList<>();

}
