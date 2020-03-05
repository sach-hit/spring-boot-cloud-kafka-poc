package com.devitapoc.hospital.information.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devitapoc.hospital.information.model.Patient;

/**
 * Created sachin.
 */
@Component
public class PatientServiceFallbackImpl implements PatientService {
    @Override
    public List<Patient> findAll(String emailAddress) {
        return Collections.emptyList();
    }

    @Override
    public Patient findOne(long id) {
        Patient patients = new Patient();
        patients.setFirstName("dummypatient");
        patients.setLastName("dummy");
        return patients;
    }
}
