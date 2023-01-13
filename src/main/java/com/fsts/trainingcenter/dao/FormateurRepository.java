package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
