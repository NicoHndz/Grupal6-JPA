package com.ejercicio6.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio6.jpa.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

}