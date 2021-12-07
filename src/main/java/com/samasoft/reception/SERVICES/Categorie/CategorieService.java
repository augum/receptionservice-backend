package com.samasoft.reception.SERVICES.Categorie;

import com.samasoft.reception.DTO.CategorieRequestDTO;
import com.samasoft.reception.DTO.CategorieResponseDTO;


import java.util.List;

public interface CategorieService {
    CategorieResponseDTO save(CategorieRequestDTO categorieRequestDTO);
    CategorieResponseDTO getCategorie(String id);
    CategorieResponseDTO update(String id,CategorieRequestDTO categorieRequestDTO);
    List<CategorieResponseDTO> listeCategorie();
}
