package com.samasoft.reception.DTO;

import com.samasoft.reception.ENTITIES.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Data @NoArgsConstructor @AllArgsConstructor
public class PatientResponseDTO {
    private String id;
    private String nom;
    private String postnom;
    private String prenom;
    private String etatCivil;
    private String sexe;
    @OneToMany
    private Nationalite nationalite;
    private String avenue;
    private String quartier;
    @OneToOne
    private Commune commune;
    private String telephone;
    private String email;
    @OneToOne
    private Localisation localisation;
    @OneToOne
    private Convention convention;
    @OneToOne
    private Categorie categorie;
    private String titulaire;
    private String matricule;
    @OneToMany
    private Profession profession;
}
