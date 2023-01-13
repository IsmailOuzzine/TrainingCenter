package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}