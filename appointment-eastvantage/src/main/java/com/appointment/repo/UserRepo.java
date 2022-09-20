package com.appointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
