package com.devitapoc.services.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devitapoc.services.domain.Patient;
import com.devitapoc.services.repository.PatientRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by sachin.
 */
@RestController
@RequestMapping(value="/patients")
@Api(value="patients", description = "Data service operations on patients", tags=("patients"))
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value="Get All Patients", notes="Gets all patients in the system", nickname="getPatients")
    public List<Patient> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress){
        if(StringUtils.isNotBlank(emailAddress)){
            return Collections.singletonList(this.patientRepository.findByEmailAddress(emailAddress));
        }
        return (List<Patient>) this.patientRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Patient> findOne(@PathVariable(name="id")long id){
        return this.patientRepository.findById(id);
    }
}

