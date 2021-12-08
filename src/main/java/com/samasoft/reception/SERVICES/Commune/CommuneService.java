package com.samasoft.reception.SERVICES.Commune;

import com.samasoft.reception.DTO.CommuneRequestDTO;
import com.samasoft.reception.DTO.CommuneResponseDTO;

import java.util.List;

public interface CommuneService {
    CommuneResponseDTO save(CommuneRequestDTO communeRequestDTO);
    CommuneResponseDTO getCommune(String id);
    CommuneResponseDTO update(String id,CommuneRequestDTO communeRequestDTO);
    List<CommuneResponseDTO> listeCommune();
    String delete(String id);
}
