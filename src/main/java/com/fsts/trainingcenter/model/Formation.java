package com.fsts.trainingcenter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double prix;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "formation")
    private Collection<Inscription> inscriptions;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "formation")
    private Collection<Commentaire> commentaires;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "formation")
    private Collection<Participation> participations;

    public Formation() {
        super();
    }

    public Formation(Long id, String nom, Double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
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

    public Collection<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(Collection<Participation> participations) {
        this.participations = participations;
    }
}
