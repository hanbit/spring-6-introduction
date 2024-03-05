package com.example.training.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.training.entity.Training;

public class JdbcTrainingRepository implements TrainingRepository {
    @Override
    public List<Training> selectAll() {
        System.out.println("데이터베이스에서 데이터를 가져옵니다.");
        // 데이터베이스에서 가져온다고 가정
        List<Training> trainings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Training training = new Training();
            training.setTitle("title_" + i);
            trainings.add(training);
        }
        return trainings;
    }
}
