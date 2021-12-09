package com.samasoft.reception.SERVICES.Localisation;

import com.samasoft.reception.DTO.ConventionResponseDTO;
import com.samasoft.reception.DTO.LocalisationRequestDTO;
import com.samasoft.reception.DTO.LocalisationResponseDTO;
import com.samasoft.reception.ENTITIES.Convention;
import com.samasoft.reception.ENTITIES.Localisation;
import com.samasoft.reception.EXCEPTIONS.RessourceNotFoundException;
import com.samasoft.reception.MAPPERS.LocalisationMapper;
import com.samasoft.reception.REPOSITORIES.LocalisationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LocalisationServiceImpl implements LocalisationService {
    private LocalisationRepository localisationRepository;
    private LocalisationMapper localisationMapper;
    @Override
    public LocalisationResponseDTO save(LocalisationRequestDTO localisationRequestDTO) {
        Localisation localisation = localisationMapper.localisationRequestDtoTolocalisation(localisationRequestDTO);
        Localisation saveLocalisation =  localisationRepository.save(localisation);
        LocalisationResponseDTO responseDTO = localisationMapper.localisationToLocalisationResponseDto(saveLocalisation);
        return responseDTO;
    }

    @Override
    public LocalisationResponseDTO getLocalisation(String id) {
        Localisation  localisation = localisationRepository.findById(id).get();
        return localisationMapper.localisationToLocalisationResponseDto(localisation);
    }

    @Override
    public LocalisationResponseDTO update(String id, LocalisationRequestDTO localisationRequestDTO) {
        //recuperation de la commune
        Localisation localisation = localisationRepository.getById(id);
        //mise à jour du libellé
        localisation.setLibelle(localisationRequestDTO.getLibelle());
        Localisation localisationUpdate = localisationRepository.save(localisation);
        return localisationMapper.localisationToLocalisationResponseDto(localisationUpdate);
    }

    @Override
    public List<LocalisationResponseDTO> listeLocalisation() {
        List<Localisation> localisations = localisationRepository.findAll();
        // retourne une liste de localisation
        return localisations.stream()
                .map(localisation->localisationMapper.localisationToLocalisationResponseDto(localisation))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Localisation localisation = localisationRepository.getById(id);
        if(localisation.getId().isEmpty()){
            new RessourceNotFoundException("Localisation not found");
        }
        localisationRepository.delete(localisation);
        return "Localisation bien supprimée";
    }
}
