package com.samasoft.reception.SERVICES.Localisation;

import com.samasoft.reception.DTO.LocalisationRequestDTO;
import com.samasoft.reception.DTO.LocalisationResponseDTO;

import java.util.List;

public interface LocalisationService {

    LocalisationResponseDTO save(LocalisationRequestDTO localisationRequestDTO);
    LocalisationResponseDTO getLocalisation(String id);
    LocalisationResponseDTO update(String id, LocalisationRequestDTO localisationRequestDTO);
    List<LocalisationResponseDTO> listeLocalisation();
}
