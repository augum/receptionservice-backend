package com.samasoft.reception.SERVICES.Patient;

import com.samasoft.reception.DTO.PatientRequestDTO;
import com.samasoft.reception.DTO.PatientResponseDTO;

import java.util.List;

public interface PatientService {

    PatientResponseDTO save(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO getPatien(String id);
    PatientResponseDTO update(String id,PatientRequestDTO patientRequestDTO);
    List<PatientResponseDTO> listePatient();

}
