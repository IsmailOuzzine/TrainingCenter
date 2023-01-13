package com.fsts.trainingcenter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date createdAt;
    private boolean valide;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    public Commentaire() {
    }

    public Commentaire(Long id, String text, Date createdAt, boolean valide, Etudiant etudiant, Formation formation) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.valide = valide;
        this.etudiant = etudiant;
        this.formation = formation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
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
