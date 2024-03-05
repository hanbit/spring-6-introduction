package com.example.training.service;

import java.util.List;

import com.example.training.entity.Training;
import com.example.training.repository.TrainingRepository;

public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<Training> findAll() {
        return trainingRepository.selectAll();
    }

}
