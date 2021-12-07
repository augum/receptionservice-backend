package com.samasoft.reception.WEBAPI;

import com.samasoft.reception.DTO.CategorieRequestDTO;
import com.samasoft.reception.DTO.CategorieResponseDTO;
import com.samasoft.reception.SERVICES.Categorie.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class CategorieWebApi {
    private CategorieService categorieService;
     // enregistrement d'une nouvelle categorie
    @PostMapping(path = "/categories/create")
    public CategorieResponseDTO save(@RequestBody CategorieRequestDTO requestDTO){
        //attribution de l'ID
        requestDTO.setId(UUID.randomUUID().toString());
        return  categorieService.save(requestDTO);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
