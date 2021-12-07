package com.samasoft.reception.REPOSITORIES;

import com.samasoft.reception.ENTITIES.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession,String> {
}
