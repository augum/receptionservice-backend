package com.samasoft.reception.SERVICES.Convention;

import com.samasoft.reception.DTO.ConventionRequestDTO;
import com.samasoft.reception.DTO.ConventionResponseDTO;
import com.samasoft.reception.ENTITIES.Convention;
import com.samasoft.reception.EXCEPTIONS.RessourceNotFoundException;
import com.samasoft.reception.MAPPERS.ConventionMapper;
import com.samasoft.reception.REPOSITORIES.ConventionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ConventionServiceImpl implements ConventionService {
    private ConventionRepository conventionRepository;
    private ConventionMapper conventionMapper;
    @Override
    public ConventionResponseDTO save(ConventionRequestDTO conventionRequestDTO) {
        Convention convention = conventionMapper.conventionRequestDtoToconvention(conventionRequestDTO);
        Convention saveConvention =  conventionRepository.save(convention);
        ConventionResponseDTO responseDTO = conventionMapper.conventionToConventionResponseDto(saveConvention);
        return responseDTO;
    }

    @Override
    public ConventionResponseDTO getConvention(String id) {
         Convention convention = conventionRepository.findById(id).get();
        return conventionMapper.conventionToConventionResponseDto(convention);
    }

    @Override
    public ConventionResponseDTO update(String id, ConventionRequestDTO conventionRequestDTO) {
        //recuperation de la commune
        Convention convention = conventionRepository.getById(id);
        //mise à jour du libellé
        convention.setLibelle(conventionRequestDTO.getLibelle());
        Convention conventioneUpdate = conventionRepository.save(convention);
        return conventionMapper.conventionToConventionResponseDto(conventioneUpdate);
    }

    @Override
    public List<ConventionResponseDTO> listeConvention() {
        List<Convention> conventions = conventionRepository.findAll();
        // retourne une liste de commune
        return conventions.stream()
                .map(convention->conventionMapper.conventionToConventionResponseDto(convention))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Convention convention = conventionRepository.getById(id);
        if(convention.getId().isEmpty()){
            new RessourceNotFoundException("Convention not found");
        }
        conventionRepository.delete(convention);
        return "Convention bien supprimée";
    }
}
