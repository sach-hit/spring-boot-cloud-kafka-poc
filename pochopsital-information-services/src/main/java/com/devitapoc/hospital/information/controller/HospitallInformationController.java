package com.devitapoc.hospital.information.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devitapoc.hospital.information.client.HospitalService;
import com.devitapoc.hospital.information.client.PatientService;
//import com.devitapoc.hospital.information.client.PatientService;
import com.devitapoc.hospital.information.model.Hospital;
import com.devitapoc.hospital.information.model.Patient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="HospitalsInformation", description = "Business process service operations on hospitals information", tags=("hopsitalInformations"))
public class HospitallInformationController {
   
	@Autowired
    private HospitalService hospitalservice;
	
	@Autowired
    private PatientService patientService;


    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    @ApiOperation(value="Get All Hospitlas", notes="Gets all hospitals in the system using hospitalNumber", nickname="getHospitals")
    public List<Hospital> getAllHospitals(@RequestParam(name="hospitalNumber", required=false)String hospitalNumber){
        return hospitalservice.findAll(hospitalNumber);
    }
    
    
    @RequestMapping(value="/patients", method= RequestMethod.GET)
    @ApiOperation(value="Get All patients", notes="Gets all patients in the system using emailaddress", nickname="getPatientbyEmail")
    List<Patient> findAll(@RequestParam(name="emailAddress", required = false) String emailAddress){
    return patientService.findAll(emailAddress);
	}
    
  
}
