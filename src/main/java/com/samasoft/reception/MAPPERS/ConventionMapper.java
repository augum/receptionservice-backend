package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.ConventionRequestDTO;
import com.samasoft.reception.DTO.ConventionResponseDTO;
import com.samasoft.reception.ENTITIES.Convention;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConventionMapper {
    ConventionResponseDTO conventionToConventionResponseDto(Convention convention);
    Convention conventionRequestDtoToconvention(ConventionRequestDTO conventionRequestDTO);
}
