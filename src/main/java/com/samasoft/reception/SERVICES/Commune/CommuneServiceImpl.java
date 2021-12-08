package com.samasoft.reception.SERVICES.Commune;

import com.samasoft.reception.DTO.CommuneRequestDTO;
import com.samasoft.reception.DTO.CommuneResponseDTO;
import com.samasoft.reception.ENTITIES.Categorie;
import com.samasoft.reception.ENTITIES.Commune;
import com.samasoft.reception.EXCEPTIONS.CategorieNotFoundException;
import com.samasoft.reception.MAPPERS.CommuneMapper;
import com.samasoft.reception.REPOSITORIES.CommuneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CommuneServiceImpl implements CommuneService {
    private CommuneMapper communeMapper;
    private CommuneRepository communeRepository;
    @Override
    public CommuneResponseDTO save(CommuneRequestDTO communeRequestDTO) {
        Commune commune = communeMapper.communeRequestDtoToCommune(communeRequestDTO);
        Commune saveCommune =  communeRepository.save(commune);
        CommuneResponseDTO responseDTO = communeMapper.communeToCommuneResponseDto(saveCommune);
        return responseDTO;
    }

    @Override
    public CommuneResponseDTO getCommune(String id) {
        Commune commune = communeRepository.findById(id).get();
        return communeMapper.communeToCommuneResponseDto(commune);
    }

    @Override
    public CommuneResponseDTO update(String id, CommuneRequestDTO communeRequestDTO) {
        //recuperation de la commune
        Commune commune = communeRepository.getById(id);
        //mise à jour du libellé
        commune.setLibelle(communeRequestDTO.getLibelle());
        Commune communeUpdate = communeRepository.save(commune);
        return communeMapper.communeToCommuneResponseDto(communeUpdate);
    }

    @Override
    public List<CommuneResponseDTO> listeCommune() {
        List<Commune> communes = communeRepository.findAll();
        // retourne une liste de commune
        return communes.stream()
                .map(commune->communeMapper.communeToCommuneResponseDto(commune))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Commune commune = communeRepository.getById(id);
        if(commune.getId().isEmpty()){
            new CategorieNotFoundException("Categorie not found");
        }
        communeRepository.delete(commune);
        return "Catégorie bien supprimée";
    }
}
