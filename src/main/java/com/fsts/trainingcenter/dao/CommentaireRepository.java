package com.fsts.trainingcenter.dao;

import com.fsts.trainingcenter.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findAllByEtudiantId(Long etudiantId);
}
