package com.samasoft.reception.SERVICES.Patient;

import com.samasoft.reception.DTO.PatientRequestDTO;
import com.samasoft.reception.DTO.PatientResponseDTO;
import com.samasoft.reception.ENTITIES.*;
import com.samasoft.reception.EXCEPTIONS.RessourceNotFoundException;
import com.samasoft.reception.MAPPERS.PatientMapper;
import com.samasoft.reception.MAPPERS.ProfessionMapper;
import com.samasoft.reception.REPOSITORIES.*;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    /*
      Injection des dependances(repositories) via le constructeur en utilisant l'annotation lombok
      @AllArgsConstructor
     */
    private PatientRepository patientRepository;
    private NationaliteRespository nationaliteRespository;
    private CommuneRepository communeRepository;
    private LocalisationRepository  localisationRepository;
    private ConventionRepository conventionRepository;
    private CategorieRepository categorieRepository;
    private ProfessionRepository professionRepository;
    private PatientMapper patientMapper;
    @Override
    public PatientResponseDTO save(PatientRequestDTO patientRequestDTO) {
        // initialisation des ressources à null
        Nationalite nationalite= null;
        Commune commune = null;
        Localisation localisation = null;
        Convention convention = null;
        Categorie categorie = null;
        Profession profession = null;
        try {
            /*
              On essaie de recuperer les informations
              sur les ressources ci-dessous pour enfin les associer au patient
             */
            nationalite = nationaliteRespository.getById(patientRequestDTO.getIdNationalite());
            commune = communeRepository.getById(patientRequestDTO.getIdCommune());
            localisation= localisationRepository.getById(patientRequestDTO.getIdLocalisation());
            convention = conventionRepository.getById(patientRequestDTO.getIdConvention());
            categorie = categorieRepository.getById(patientRequestDTO.getIdCategorie());
            profession= professionRepository.getById(patientRequestDTO.getIdProfession());
        }
        catch (Exception e)
        {
            throw new RessourceNotFoundException("Ressources not found");
        }
        Patient patient = patientMapper.patientrequestdtoTopatient(patientRequestDTO);
        Patient savePatient = patientRepository.save(patient);
        savePatient.setNationalite(nationalite);
        savePatient.setCommune(commune);
        savePatient.setLocalisation(localisation);
        savePatient.setConvention(convention);
        savePatient.setCategorie(categorie);
        savePatient.setProfession(profession);
        PatientResponseDTO responseDTO = patientMapper.patientToPatientResponsedto(savePatient);
        return responseDTO;
    }

    @Override
    public PatientResponseDTO getPatien(String id) {
        Patient patient = patientRepository.findById(id).get();
        Nationalite nationalite = nationaliteRespository.getById(patient.getIdNationalite());
        Commune commune = communeRepository.getById(patient.getIdCommune());
        Localisation localisation= localisationRepository.getById(patient.getIdLocalisation());
        Convention convention = conventionRepository.getById(patient.getIdConvention());
        Categorie categorie = categorieRepository.getById(patient.getIdCategorie());
        Profession profession= professionRepository.getById(patient.getIdProfession());

        patient.setNationalite(nationalite);
        patient.setCommune(commune);
        patient.setLocalisation(localisation);
        patient.setConvention(convention);
        patient.setCategorie(categorie);
        patient.setProfession(profession);
        return patientMapper.patientToPatientResponsedto(patient);
    }

    @Override
    public PatientResponseDTO update(String id, PatientRequestDTO patientRequestDTO) {
        // initialisation des ressources à null
        Nationalite nationalite= null;
        Commune commune = null;
        Localisation localisation = null;
        Convention convention = null;
        Categorie categorie = null;
        Profession profession = null;
        try {
            /*
              On essaie de recuperer les informations
              sur les ressources ci-dessous pour enfin les associer au patient
             */
            nationalite = nationaliteRespository.getById(patientRequestDTO.getIdNationalite());
            commune = communeRepository.getById(patientRequestDTO.getIdCommune());
            localisation= localisationRepository.getById(patientRequestDTO.getIdLocalisation());
            convention = conventionRepository.getById(patientRequestDTO.getIdConvention());
            categorie = categorieRepository.getById(patientRequestDTO.getIdCategorie());
            profession= professionRepository.getById(patientRequestDTO.getIdProfession());
        }
        catch (Exception e)
        {
            throw new RessourceNotFoundException("Ressources not found");
        }

        Patient patient = patientRepository.getById(id);
        patient.setNom(patientRequestDTO.getNom());
        patient.setPostnom(patientRequestDTO.getPostnom());
        patient.setPrenom(patientRequestDTO.getPrenom());
        patient.setEtatCivil(patientRequestDTO.getEtatCivil());
        patient.setSexe(patientRequestDTO.getSexe());
        patient.setIdNationalite(patientRequestDTO.getIdNationalite());
        patient.setAvenue(patientRequestDTO.getAvenue());
        patient.setQuartier(patientRequestDTO.getQuartier());
        patient.setIdCommune(patientRequestDTO.getIdCommune());
        patient.setTelephone(patientRequestDTO.getTelephone());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setIdLocalisation(patientRequestDTO.getIdLocalisation());
        patient.setIdConvention(patientRequestDTO.getIdConvention());
        patient.setIdCategorie(patientRequestDTO.getIdCategorie());
        patient.setTitulaire(patientRequestDTO.getTitulaire());
        patient.setMatricule(patientRequestDTO.getMatricule());
        patient.setIdProfession(patientRequestDTO.getIdProfession());

        Patient patientUpdate = patientRepository.save(patient);
        /*
         Association des ressources au patient mis à jour
         */
         patientUpdate.setNationalite(nationalite);
         patientUpdate.setCommune(commune);
         patientUpdate.setLocalisation(localisation);
         patientUpdate.setConvention(convention);
         patientUpdate.setCategorie(categorie);
         patientUpdate.setProfession(profession);
        return patientMapper.patientToPatientResponsedto(patientUpdate);
    }

    @Override
    public List<PatientResponseDTO> listePatient() {
        List<Patient> patients = patientRepository.findAll();
        for(Patient patient:patients){
            Nationalite nationalite = nationaliteRespository.getById(patient.getIdNationalite());
            Commune commune = communeRepository.getById(patient.getIdCommune());
            Localisation localisation= localisationRepository.getById(patient.getIdLocalisation());
            Convention convention = conventionRepository.getById(patient.getIdConvention());
            Categorie categorie = categorieRepository.getById(patient.getIdCategorie());
            Profession profession= professionRepository.getById(patient.getIdProfession());

            patient.setNationalite(nationalite);
            patient.setCommune(commune);
            patient.setLocalisation(localisation);
            patient.setConvention(convention);
            patient.setCategorie(categorie);
            patient.setProfession(profession);
        }
        return patients.stream()
                .map(patient->patientMapper.patientToPatientResponsedto(patient))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Patient patient = patientRepository.getById(id);
        if(patient.getId().isEmpty()){
            new RessourceNotFoundException("Profession not found");
        }
        patientRepository.delete(patient);
        return "Profession bien supprimée";
    }
}
