package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.ProfessionRequestDTO;
import com.samasoft.reception.DTO.ProfessionResponseDTO;
import com.samasoft.reception.ENTITIES.Profession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessionMapper {
    ProfessionResponseDTO professionToProfessionResponseDto(Profession profession);
    Profession professionrequestdtoToprofession(ProfessionRequestDTO professionRequestDTO);
}
