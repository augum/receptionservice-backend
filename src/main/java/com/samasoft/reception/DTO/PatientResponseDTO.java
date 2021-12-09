package com.samasoft.reception.DTO;

import com.samasoft.reception.ENTITIES.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Data @NoArgsConstructor @AllArgsConstructor
public class PatientResponseDTO {
    private String id;
    private String nom;
    private String postnom;
    private String prenom;
    private String etatCivil;
    private String sexe;
    private String idNationalite;
    private String avenue;
    private String quartier;
    private String idCommune;
    private String telephone;
    private String email;
    private String idLocalisation;
    private String idConvention;
    private String idCategorie;
    private String titulaire;
    private String matricule;
    private String idProfession;

}
