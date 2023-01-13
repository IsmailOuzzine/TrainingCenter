package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}
