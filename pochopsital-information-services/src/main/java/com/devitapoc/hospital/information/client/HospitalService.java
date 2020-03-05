package com.devitapoc.hospital.information.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devitapoc.hospital.information.model.Hospital;

/**
 * Created by sachin.
 */

@FeignClient(value="HOSPITALSERVICES")
public interface HospitalService {

    @RequestMapping(value="/hospitals", method= RequestMethod.GET)
    List<Hospital> findAll(@RequestParam(name="hosptalNumber", required=false)String hospitalNumber);

   // @RequestMapping(value="/hospitals/{id}", method = RequestMethod.GET)
   // Hospital findOne(@PathVariable("id")long id);
    
   // @RequestMapping(value="/hospitalid", method= RequestMethod.GET)
    //Hospital findByHospitalbyId (@RequestParam(name="hospitalId", required=false)long id);

    @RequestMapping(value="/hospitalid", method= RequestMethod.GET)
	Hospital findByHospitalbyId (@RequestParam(name="hospitalId", required=false)long id);
    
   

}