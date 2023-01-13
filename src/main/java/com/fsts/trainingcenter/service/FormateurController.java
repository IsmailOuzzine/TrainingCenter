package com.fsts.trainingcenter.service;

import com.fsts.trainingcenter.dao.FormateurRepository;
import com.fsts.trainingcenter.model.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
public class FormateurController {

    @Autowired
    private FormateurRepository formateurRepository;

    @GetMapping("/")
    public List<Formateur> getAllFormateurs(){
        return formateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Formateur getFormateurById(@PathVariable Long id){
        return formateurRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Formateur addFormateur(@RequestBody Formateur formateur){
        return formateurRepository.save(formateur);
    }

    @PutMapping("/")
    public Formateur modifyFormateur(@RequestBody Formateur formateur){
        return formateurRepository.save(formateur);
    }

    @DeleteMapping("/{id}")
    public void deleteFormateurById(@PathVariable Long id){
        formateurRepository.deleteById(id);
    }
}
