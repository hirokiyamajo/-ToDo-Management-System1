package com.dmm.task1.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmm.task1.data.entity.Users;


public interface UsersRepository extends JpaRepository<Users, String>{

}
