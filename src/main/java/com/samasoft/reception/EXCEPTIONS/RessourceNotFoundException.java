package com.samasoft.reception.EXCEPTIONS;

import com.samasoft.reception.ENTITIES.Categorie;

public class RessourceNotFoundException extends RuntimeException {
    public RessourceNotFoundException(String message) {
        super(message);
    }
}
