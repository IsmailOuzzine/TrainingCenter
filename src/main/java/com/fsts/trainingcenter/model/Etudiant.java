package com.fsts.trainingcenter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "etudiant")
    Collection<Inscription> inscriptions;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "etudiant")
    Collection<Commentaire> commentaires;

    public Etudiant() {
        super();
    }

    public Etudiant(Long id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Collection<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Collection<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
