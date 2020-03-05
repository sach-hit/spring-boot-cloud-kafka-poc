package com.devitapoc.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devitapoc.services.domain.Patient;

/**
 * Created by sachin
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
    Patient findByEmailAddress(String emailAddress);
}
