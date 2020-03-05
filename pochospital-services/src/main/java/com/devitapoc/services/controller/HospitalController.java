package com.devitapoc.services.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devitapoc.services.domain.Hospital;
import com.devitapoc.services.repository.HospitalRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by sachin
 */
@RestController
@RequestMapping(value="/hospitals")
@Api(value="hospitals", description = "Data service operations on hospitals", tags=("hospitals"))
public class HospitalController {
    
	@Autowired
    private HospitalRepository hospitalRepository;

	@GetMapping
    @ApiOperation(value="Get All Hospitals", notes="Gets all hospitals in the system", nickname="getHospitals")
    public List<Hospital> findAll(@RequestParam(name="hospitalNumber", required = false)String hospitalNumber){
        
    	if(StringUtils.isNotEmpty(hospitalNumber)){
            return Collections.singletonList(this.hospitalRepository.findByHospitalNumber(hospitalNumber));
        }
        return (List<Hospital>) hospitalRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Get hospital", notes="Gets a single hospital based on its unique id", nickname = "getHospital")
    public Optional<Hospital>findOne(@PathVariable("id")long id){
        return hospitalRepository.findById(id);
    }
    
    
    
}
