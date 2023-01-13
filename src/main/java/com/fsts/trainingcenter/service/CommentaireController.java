package com.fsts.trainingcenter.service;

import com.fsts.trainingcenter.dao.CommentaireRepository;
import com.fsts.trainingcenter.model.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireRepository repository;

    @GetMapping("/")
    public List<Commentaire> getAllCommentaires() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Commentaire getCommentaireById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(null);
        // Use .orElse(null) instead of .get() to catch when {id} doesn't exist
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaireById(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @PostMapping("/")
    public Commentaire addCommentaire(@RequestBody Commentaire commentaire) {
        commentaire.setValide(false);
        commentaire.setCreatedAt(new Date());
        return repository.save(commentaire);
    }

    @PutMapping("/")
    public Commentaire ModifyCommentaire(@RequestBody Commentaire commentaire) {
        return repository.save(commentaire);
    }
}
