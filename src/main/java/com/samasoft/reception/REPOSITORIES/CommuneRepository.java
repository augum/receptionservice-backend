package com.samasoft.reception.REPOSITORIES;

import com.samasoft.reception.ENTITIES.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune,String> {
}
