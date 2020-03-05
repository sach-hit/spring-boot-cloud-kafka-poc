package com.devoc.cloud.stream.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sachin
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
  
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String country;
    private String state;
    private String phoneNumber;

}