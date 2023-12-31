package com.ejercicio6.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejercicio6.jpa.model.Contact;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ContactsRepository extends JpaRepository<Contact, Integer> {

}
