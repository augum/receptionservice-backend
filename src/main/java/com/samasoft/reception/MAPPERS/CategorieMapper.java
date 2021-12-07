package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.CategorieRequestDTO;
import com.samasoft.reception.DTO.CategorieResponseDTO;
import com.samasoft.reception.ENTITIES.Categorie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategorieMapper {

    CategorieResponseDTO categorieToCategorieResponseDto(Categorie categorie);
    Categorie categorieRequestDtoToCategorie(CategorieRequestDTO categorieRequestDTO);
}
