package com.example.training.repository;

import java.util.List;

import com.example.training.entity.Training;

public interface TrainingRepository {
    List<Training> selectAll();
}
