package com.samasoft.reception.SERVICES.Nationalite;

import com.samasoft.reception.DTO.NationaliteRequestDTO;
import com.samasoft.reception.DTO.NationaliteResponseDTO;

import java.util.List;

public interface NationaliteService {
    NationaliteResponseDTO save(NationaliteRequestDTO nationaliteRequestDTO);
    NationaliteResponseDTO getNationalie(String id);
    NationaliteResponseDTO update(String id, NationaliteRequestDTO nationaliteRequestDTO);
    List<NationaliteResponseDTO> listeNationalite();
}
