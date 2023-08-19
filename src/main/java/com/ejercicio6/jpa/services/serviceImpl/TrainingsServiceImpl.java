package com.ejercicio6.jpa.services.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ejercicio6.jpa.services.TrainingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ejercicio6.jpa.model.Training;
import com.ejercicio6.jpa.repositories.TrainingsRepository;

@Service
public class TrainingsServiceImpl implements TrainingsService {

	private final TrainingsRepository trainingsRepository;

	public TrainingsServiceImpl(TrainingsRepository trainingsRepository) {
		this.trainingsRepository = trainingsRepository;
	}

	@Override
	public List<Training> getTrainings() {
		return trainingsRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> newTraining(Training training) {
		Optional<Training> result = trainingsRepository.findById(training.getIdTraining());
		HashMap<String, Object> data = new HashMap<>();

		if (result.isPresent()) {
			data.put("error", true);
			data.put("message", "Already exists");
			return new ResponseEntity<>(data, HttpStatus.CONFLICT);
		}
		trainingsRepository.save(training);
		data.put("data", training);
		data.put("message", "Save Successfully");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateTraining(Training training) {
		Optional<Training> trainingToUpdate = trainingsRepository.findById(training.getIdTraining());
		HashMap<String, Object> data = new HashMap<>();

		if (!trainingToUpdate.isPresent()) {
			data.put("error", true);
			data.put("message", "Not Found");
			return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		}
		trainingsRepository.save(training);
		data.put("data", training);
		data.put("message", "Update Successfully");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteTraining(int id) {
		HashMap<String, Object> data = new HashMap<>();

		if (!trainingsRepository.findById(id).isPresent()) {
			data.put("error", true);
			data.put("message", "Not Found");
			return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		}
		trainingsRepository.deleteById(id);
		data.put("data", id);
		data.put("message", "Delete Successfully");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getTraining(int id) {
		HashMap<String, Object> data = new HashMap<>();
		Optional<Training> training = trainingsRepository.findById(id);
		if (!training.isPresent()) {
			data.put("error", true);
			data.put("message", "Not Found");
			return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		}
		data.put("data", training);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
