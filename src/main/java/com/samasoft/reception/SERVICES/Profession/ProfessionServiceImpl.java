package com.samasoft.reception.SERVICES.Profession;

import com.samasoft.reception.DTO.NationaliteResponseDTO;
import com.samasoft.reception.DTO.ProfessionRequestDTO;
import com.samasoft.reception.DTO.ProfessionResponseDTO;
import com.samasoft.reception.ENTITIES.Nationalite;
import com.samasoft.reception.ENTITIES.Profession;
import com.samasoft.reception.EXCEPTIONS.RessourceNotFoundException;
import com.samasoft.reception.MAPPERS.ProfessionMapper;
import com.samasoft.reception.REPOSITORIES.ProfessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {
    private ProfessionRepository professionRepository;
    private ProfessionMapper professionMapper;
    @Override
    public ProfessionResponseDTO save(ProfessionRequestDTO professionRequestDTO) {
        Profession profession = professionMapper.professionrequestdtoToprofession(professionRequestDTO);
        Profession saveProfession =  professionRepository.save(profession);
        ProfessionResponseDTO responseDTO = professionMapper.professionToProfessionResponseDto(saveProfession);
        return responseDTO;
    }

    @Override
    public ProfessionResponseDTO getProfession(String id) {
        Profession profession = professionRepository.findById(id).get();
        return professionMapper.professionToProfessionResponseDto(profession);
    }

    @Override
    public ProfessionResponseDTO update(String id, ProfessionRequestDTO professionRequestDTO) {
        //recuperation de la nationalite
        Profession profession = professionRepository.getById(id);
        //mise à jour du libellé
        profession.setLibelle(professionRequestDTO.getLibelle());
        Profession professionUpdate = professionRepository.save(profession);
        return professionMapper.professionToProfessionResponseDto(professionUpdate);
    }

    @Override
    public List<ProfessionResponseDTO> listeProfession() {
        List<Profession> professions = professionRepository.findAll();
        // retourne une liste de profession
        return professions.stream()
                .map(profession->professionMapper.professionToProfessionResponseDto(profession))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Profession profession = professionRepository.getById(id);
        if(profession.getId().isEmpty()){
            new RessourceNotFoundException("Profession not found");
        }
        professionRepository.delete(profession);
        return "Profession bien supprimée";
    }
}
