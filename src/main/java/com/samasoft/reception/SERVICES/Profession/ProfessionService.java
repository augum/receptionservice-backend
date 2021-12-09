package com.samasoft.reception.SERVICES.Profession;

import com.samasoft.reception.DTO.ProfessionRequestDTO;
import com.samasoft.reception.DTO.ProfessionResponseDTO;

import java.util.List;

public interface ProfessionService {
    ProfessionResponseDTO save(ProfessionRequestDTO professionRequestDTO);
    ProfessionResponseDTO getProfession(String id);
    ProfessionResponseDTO update(String id, ProfessionRequestDTO professionRequestDTO);
    List<ProfessionResponseDTO> listeProfession();
    String delete(String id);
}
