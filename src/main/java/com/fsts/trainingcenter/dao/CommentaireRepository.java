package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
