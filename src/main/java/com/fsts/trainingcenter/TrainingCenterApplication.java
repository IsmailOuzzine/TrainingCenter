package com.fsts.trainingcenter;

import com.fsts.trainingcenter.dao.FormationRepository;
import com.fsts.trainingcenter.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TrainingCenterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrainingCenterApplication.class, args);
    }

    @Autowired
    FormationRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Training center API is running. http://localhost:8080/");
    }
}
