package com.hospital.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.appointment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
