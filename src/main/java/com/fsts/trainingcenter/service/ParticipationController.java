package com.fsts.trainingcenter.service;

import com.fsts.trainingcenter.dao.EtudiantRepository;
import com.fsts.trainingcenter.dao.ParticipationRepository;
import com.fsts.trainingcenter.model.Etudiant;
import com.fsts.trainingcenter.model.Participation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participations")
public class ParticipationController {

    @Autowired
    private ParticipationRepository repository;

    @GetMapping("/")
    public List<Participation> getAllParticipations(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Participation getParticipationById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
        // Use .orElse(null) instead of .get() to catch when {id} doesn't exist
    }


    @PostMapping("/")
    public Participation addParticipation(@RequestBody Participation participation){
        return repository.save(participation);
    }

    @PutMapping("/")
    public Participation modifyParticipation(@RequestBody Participation participation){
        return repository.save(participation);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipationById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
