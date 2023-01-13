package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
