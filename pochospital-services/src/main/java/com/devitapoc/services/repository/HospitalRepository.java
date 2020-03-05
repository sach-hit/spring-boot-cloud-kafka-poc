package com.devitapoc.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devitapoc.services.domain.Hospital;

/**
 * Created by sachin.
 */
@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long>{
    Hospital findByHospitalNumber(String hospitalNumber);

}
