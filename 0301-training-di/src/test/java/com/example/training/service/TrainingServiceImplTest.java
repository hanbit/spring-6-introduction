package com.example.training.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.training.entity.Training;

class TrainingServiceImplTest {
    @Test
    public void test_findAll() {
        TrainingService trainingService = null;

        List<Training> trainings = trainingService.findAll();
        // 결과 확인
        Assertions.assertThat(trainings.size()).isEqualTo(10);
    }
}