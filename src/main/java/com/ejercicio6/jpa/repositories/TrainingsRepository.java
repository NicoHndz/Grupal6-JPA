package com.ejercicio6.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio6.jpa.model.Training;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TrainingsRepository extends JpaRepository<Training, Integer> {

}
