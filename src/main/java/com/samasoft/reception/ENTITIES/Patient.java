package com.samasoft.reception.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id
    private String id;
    private String nom;
    private String postnom;
    private String prenom;
    private String etatCivil;
    private String sexe;
    private String idNationalite;
    @Transient
    private Nationalite nationalite;
    private String avenue;
    private String quartier;
    private String idCommune;
    @Transient
    private Commune commune;
    private String telephone;
    private String email;
    private String idLocalisation;
    @Transient
    private Localisation localisation;
    private String idConvention;
    @Transient
    private Convention convention;
    private String idCategorie;
    @Transient
    private Categorie categorie;
    private String titulaire;
    private String matricule;
    private String idProfession;
    @Transient
    private Profession profession;
}
