package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
