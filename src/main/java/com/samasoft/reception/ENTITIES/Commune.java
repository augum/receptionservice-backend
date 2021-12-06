package com.samasoft.reception.ENTITIES;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Commune {
    @Id
    private String Id;
    private String Libelle;
}
