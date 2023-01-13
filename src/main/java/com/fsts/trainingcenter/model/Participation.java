package com.fsts.trainingcenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    public Participation() {
    }

    public Participation(Long id, Double montant, Formateur formateur, Formation formation) {
        this.id = id;
        this.montant = montant;
        this.formateur = formateur;
        this.formation = formation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
