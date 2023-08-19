package com.ejercicio6.jpa.services.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ejercicio6.jpa.services.ContactsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ejercicio6.jpa.model.Contact;
import com.ejercicio6.jpa.repositories.ContactsRepository;

@Service
public class ContactsServiceImpl implements ContactsService {

	private final ContactsRepository contactsRepository;

	public ContactsServiceImpl(ContactsRepository contactsRespository) {
		this.contactsRepository = contactsRespository;
	}

	@Override
	public List<Contact> getContacts() {
		return contactsRepository.findAll();
	}

	@Override
	public Contact newContact(Contact contact) {
		return contactsRepository.save(contact);
	}

	@Override
	public ResponseEntity<Object> updateContact(Contact contact) {
		Optional<Contact> contactToUpdate = contactsRepository.findById(contact.getIdContact());
		HashMap<String, Object> data = new HashMap<>();

		if (!contactToUpdate.isPresent()) {
			data.put("error", true);
			data.put("message", "Not Found");
			return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		}
		contactsRepository.save(contact);
		data.put("data", contact);
		data.put("message", "Update Successfully");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteContact(int id) {
		HashMap<String, Object> data = new HashMap<>();

		if (!contactsRepository.findById(id).isPresent()) {
			data.put("error", true);
			data.put("message", "Not Found");
			return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		}
		contactsRepository.deleteById(id);
		data.put("data", id);
		data.put("message", "Delete Successfully");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getContact(int id) {
		HashMap<String, Object> data = new HashMap<>();
		Optional<Contact> contact = contactsRepository.findById(id);
		if (!contact.isPresent()) {
			data.put("error", true);
			data.put("message", "Not Found");
			return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		}
		data.put("data", contact);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
