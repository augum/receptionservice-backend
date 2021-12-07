package com.samasoft.reception.SERVICES.Convention;

import com.samasoft.reception.DTO.CategorieResponseDTO;
import com.samasoft.reception.DTO.CommuneRequestDTO;
import com.samasoft.reception.DTO.ConventionRequestDTO;
import com.samasoft.reception.DTO.ConventionResponseDTO;

import java.util.List;

public interface ConventionService {
    ConventionResponseDTO save(CommuneRequestDTO communeRequestDTO);
    ConventionResponseDTO getConvention(String id);
    ConventionResponseDTO update(String id, ConventionRequestDTO conventionRequestDTO);
    List<ConventionResponseDTO> listeConvention();
}
