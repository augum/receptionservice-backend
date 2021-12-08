package com.samasoft.reception.WEBAPI;

import com.samasoft.reception.DTO.CategorieRequestDTO;
import com.samasoft.reception.DTO.CategorieResponseDTO;
import com.samasoft.reception.SERVICES.Categorie.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class CategorieWebApi {
    private CategorieService categorieService;
     // enregistrement d'une nouvelle categorie
    @PostMapping(path = "/categories")
    public CategorieResponseDTO save(@RequestBody CategorieRequestDTO requestDTO){
        //attribution de l'ID
        requestDTO.setId(UUID.randomUUID().toString());
        return  categorieService.save(requestDTO);
    }
    @PutMapping(path = "/categories/{id}")
    public CategorieResponseDTO update(@PathVariable String id,@RequestBody CategorieRequestDTO categorieRequestDTO){
        return categorieService.update(id,categorieRequestDTO);
    }
    @DeleteMapping(path = "/categories/{id}")
    public void delete(@PathVariable String id){
        categorieService.delete(id);
    }
    @GetMapping(path = "/categories/{id}")

    public CategorieResponseDTO getArticle(@PathVariable String id){
        return categorieService.getCategorie(id);
    }
    @GetMapping(path = "/categories")
    public List<CategorieResponseDTO> getListArticle(){
        return categorieService.listeCategorie();
    }
    
    //pour gerer les exceptions métiers
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
