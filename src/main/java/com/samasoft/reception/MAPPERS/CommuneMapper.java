package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.CommuneRequestDTO;
import com.samasoft.reception.DTO.CommuneResponseDTO;
import com.samasoft.reception.ENTITIES.Commune;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommuneMapper {
    CommuneResponseDTO communeToCommuneResponseDto(Commune commune);
    Commune communeRequestDtoToCommune(CommuneRequestDTO communeRequestDTO);
}
