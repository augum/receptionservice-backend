package com.samasoft.reception.MAPPERS;

import com.samasoft.reception.DTO.PatientRequestDTO;
import com.samasoft.reception.DTO.PatientResponseDTO;
import com.samasoft.reception.ENTITIES.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientResponseDTO patientToPatientResponsedto(Patient patient);
    Patient patientrequestdtoTopatient(PatientRequestDTO CategorieResponseDTO);
}
