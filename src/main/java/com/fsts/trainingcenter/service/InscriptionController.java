package com.fsts.trainingcenter.service;

import com.fsts.trainingcenter.InscriptionExcelExporter;
import com.fsts.trainingcenter.dao.InscriptionRepository;
import com.fsts.trainingcenter.model.Inscription;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionRepository repository;

    @GetMapping("/")
    public List<Inscription> getAllInscriptions() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Inscription getInscriptionById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(null);
        // Use .orElse(null) instead of .get() to catch when {id} doesn't exist
    }

    @DeleteMapping("/{id}")
    public void deleteInscriptionById(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @PostMapping("/")
    public Inscription addInscription(@RequestBody Inscription inscription) {
        inscription.setValide(false);
        inscription.setCreatedAt(new Date());
        return repository.save(inscription);
    }

    @PutMapping("/")
    public Inscription ModifyInscription(@RequestBody Inscription inscription) {
        return repository.save(inscription);
    }

    @GetMapping("/exportexcel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Inscriptions_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Inscription> listInscriptions = repository.findAll();

        InscriptionExcelExporter excelExporter = new InscriptionExcelExporter(listInscriptions);

        excelExporter.export(response);
    }
}
