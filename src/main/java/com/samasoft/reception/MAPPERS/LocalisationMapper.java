package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.LocalisationRequestDTO;
import com.samasoft.reception.DTO.LocalisationResponseDTO;
import com.samasoft.reception.ENTITIES.Localisation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalisationMapper {
    LocalisationResponseDTO localisationToLocalisationResponseDto(Localisation localisation);
    Localisation localisationRequestDtoTolocalisation(LocalisationRequestDTO  localisationRequestDTO);
}
