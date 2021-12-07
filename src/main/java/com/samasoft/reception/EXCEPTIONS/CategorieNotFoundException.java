package com.samasoft.reception.EXCEPTIONS;

import com.samasoft.reception.ENTITIES.Categorie;

public class CategorieNotFoundException extends RuntimeException {
    public CategorieNotFoundException(String message) {
        super(message);
    }
}
