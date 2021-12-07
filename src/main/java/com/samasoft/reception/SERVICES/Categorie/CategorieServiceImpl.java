package com.samasoft.reception.SERVICES.Categorie;

import com.samasoft.reception.DTO.CategorieRequestDTO;
import com.samasoft.reception.DTO.CategorieResponseDTO;
import com.samasoft.reception.ENTITIES.Categorie;
import com.samasoft.reception.EXCEPTIONS.CategorieNotFoundException;
import com.samasoft.reception.MAPPERS.CategorieMapper;
import com.samasoft.reception.REPOSITORIES.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    /*Importation de repository
     et de mapper pour la classe categorie
     */
    private CategorieRepository categorieRepository;
    private CategorieMapper categorieMapper;
    //Création d'une categorie
    @Override
    public CategorieResponseDTO save(CategorieRequestDTO categorieRequestDTO) {
        /*On fait appel au mapper pour convertir categorieRequestDTO à categorie pour le persister à la BDD
          en suite on doit renvoier la categorie enregistrée, pour cela on doit encore faire appel au mapper pour
          convertir categorie au categorieResponseDTO
         */
        Categorie categorie = categorieMapper.categorieRequestDtoToCategorie(categorieRequestDTO);
        Categorie categorieSave = categorieRepository.save(categorie);
        CategorieResponseDTO categorieResponseDTO = categorieMapper.categorieToCategorieResponseDto(categorieSave);
        return categorieResponseDTO;
    }
    // Recupération d'une categorie
    @Override
    public CategorieResponseDTO getCategorie(String id) {
        // Recupération d'une categorie
        Categorie categorie = categorieRepository.findById(id).get();
        return categorieMapper.categorieToCategorieResponseDto(categorie);
    }
    // La mise à jour de la catégorie
    @Override
    public CategorieResponseDTO update(String id, CategorieRequestDTO categorieRequestDTO) {
        //recuperation de la catégorie
        Categorie categorie = categorieRepository.getById(id);
        //mise à jour du libellé
        categorie.setLibelle(categorieRequestDTO.getLibelle());
        Categorie categorieUpdate = categorieRepository.save(categorie);
        return categorieMapper.categorieToCategorieResponseDto(categorieUpdate);
    }
   // la liste de toutes les catégories
    @Override
    public List<CategorieResponseDTO> listeCategorie() {
        List<Categorie> categories = categorieRepository.findAll();
     // retourne une liste d'article
        return categories.stream()
                .map(categorie->categorieMapper.categorieToCategorieResponseDto(categorie))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Categorie categorie = categorieRepository.getById(id);
        if(categorie.getId().isEmpty()){
            new CategorieNotFoundException("Categorie not found");
        }
         categorieRepository.delete(categorie);
        return "Catégorie bien supprimée";
    }
}
