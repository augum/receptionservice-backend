package com.samasoft.reception.REPOSITORIES;

import com.samasoft.reception.ENTITIES.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,String> {
}
