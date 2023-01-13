package com.fsts.trainingcenter.service;

import com.fsts.trainingcenter.dao.FormationRepository;
import com.fsts.trainingcenter.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/formations")
public class FormationController {

    @Autowired
    private FormationRepository repository;

    @GetMapping("/")
    public List<Formation> getAllFormations() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Formation getFormationById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(null);
        // Use .orElse(null) instead of .get() to catch when {id} doesn't exist
    }

    @DeleteMapping("/{id}")
    public void deleteFormationById(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @PostMapping("/")
    public Formation addFormation(@RequestBody Formation formation) {
        return repository.save(formation);
    }

    @PutMapping("/")
    public Formation ModifyFormation(@RequestBody Formation formation) {
        return repository.save(formation);
    }
}
