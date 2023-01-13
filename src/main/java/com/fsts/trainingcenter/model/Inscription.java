package com.fsts.trainingcenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean valide;
    private Date createdAt;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    public Inscription() {
    }

    public Inscription(Long id, boolean valide, Date createdAt, Etudiant etudiant, Formation formation) {
        this.id = id;
        this.valide = valide;
        this.createdAt = createdAt;
        this.etudiant = etudiant;
        this.formation = formation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
