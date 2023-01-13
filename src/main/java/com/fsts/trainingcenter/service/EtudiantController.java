package com.fsts.trainingcenter.service;

import com.fsts.trainingcenter.UserExcelExporter;
import com.fsts.trainingcenter.dao.CommentaireRepository;
import com.fsts.trainingcenter.dao.EtudiantRepository;
import com.fsts.trainingcenter.model.Commentaire;
import com.fsts.trainingcenter.model.Etudiant;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    
    @Autowired
    private EtudiantRepository repository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @GetMapping("/")
    public List<Etudiant> findAllEtudiants(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
        // Use .orElse(null) instead of .get() to catch when {id} doesn't exist
    }

    @PostMapping("/")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return repository.save(etudiant);
    }

    @PutMapping("/")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant){
        return repository.save(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiantById(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/commentaires/")
    public Collection<Commentaire> getCommentairesByEtudiant() {
        return commentaireRepository.findAll();
    }

    @GetMapping("/exportexcel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Etudiants_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Etudiant> listUsers = repository.findAll();

        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);

        excelExporter.export(response);
    }
}
