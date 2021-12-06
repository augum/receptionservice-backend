package com.samasoft.reception.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Profession {
    @Id
    private String id;
    private String libelle;
}
