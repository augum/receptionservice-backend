package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.NationaliteRequestDTO;
import com.samasoft.reception.DTO.NationaliteResponseDTO;
import com.samasoft.reception.ENTITIES.Nationalite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NationaliteMapper {
    NationaliteResponseDTO nationaliteToNationaliteResponseDto(Nationalite nationalite);
    Nationalite nationaliteRequetdtoToNationalite(NationaliteRequestDTO nationaliteRequestDTO);
}
