package com.samasoft.reception.SERVICES.Nationalite;


import com.samasoft.reception.DTO.NationaliteRequestDTO;
import com.samasoft.reception.DTO.NationaliteResponseDTO;
import com.samasoft.reception.ENTITIES.Localisation;
import com.samasoft.reception.ENTITIES.Nationalite;
import com.samasoft.reception.EXCEPTIONS.RessourceNotFoundException;
import com.samasoft.reception.MAPPERS.NationaliteMapper;
import com.samasoft.reception.REPOSITORIES.NationaliteRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class NationaliteServiceImpl implements NationaliteService {
    private NationaliteRespository nationaliteRespository;
    private NationaliteMapper nationaliteMapper;
    @Override
    public NationaliteResponseDTO save(NationaliteRequestDTO nationaliteRequestDTO) {
        Nationalite nationalite = nationaliteMapper.nationaliteRequetdtoToNationalite(nationaliteRequestDTO);
        Nationalite saveNationalite =  nationaliteRespository.save(nationalite);
        NationaliteResponseDTO responseDTO = nationaliteMapper.nationaliteToNationaliteResponseDto(saveNationalite);
        return responseDTO;
    }

    @Override
    public NationaliteResponseDTO getNationalie(String id) {
         Nationalite nationalite = nationaliteRespository.findById(id).get();
        return nationaliteMapper.nationaliteToNationaliteResponseDto(nationalite);
    }

    @Override
    public NationaliteResponseDTO update(String id, NationaliteRequestDTO nationaliteRequestDTO) {
        //recuperation de la nationalite
        Nationalite nationalite = nationaliteRespository.getById(id);
        //mise à jour du libellé
        nationalite.setLibelle(nationaliteRequestDTO.getLibelle());
        Nationalite nationaliteUpdate = nationaliteRespository.save(nationalite);
        return nationaliteMapper.nationaliteToNationaliteResponseDto(nationaliteUpdate);
    }

    @Override
    public List<NationaliteResponseDTO> listeNationalite() {
        List<Nationalite> nationalites = nationaliteRespository.findAll();
        // retourne une liste de localisation
        return nationalites.stream()
                .map(nationalite->nationaliteMapper.nationaliteToNationaliteResponseDto(nationalite))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Nationalite nationalite = nationaliteRespository.getById(id);
        if(nationalite.getId().isEmpty()){
            new RessourceNotFoundException("Nationalite not found");
        }
        nationaliteRespository.delete(nationalite);
        return "Nationalite bien supprimée";
    }
}
