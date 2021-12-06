package com.samasoft.reception.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Nationalite {
    @Id
    private String id;
    private String libelle;
}
