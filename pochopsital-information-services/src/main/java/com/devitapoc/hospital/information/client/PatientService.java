package com.devitapoc.hospital.information.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devitapoc.hospital.information.model.Patient;


import java.util.List;

/**
 * Created by sachin
 */
@FeignClient(value = "PATIENTSERVICES", fallback = PatientServiceFallbackImpl.class)
public interface PatientService {

    @RequestMapping(value="/patients", method= RequestMethod.GET)
    List<Patient> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress);

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    Patient findOne(@PathVariable(name="id")long id);
}

