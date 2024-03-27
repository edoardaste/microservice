package com.microservice.user.controller;

import com.microservice.user.models.PatientsModel;
import com.microservice.user.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class PatientsController {

    @Autowired
    PatientsRepository patientRepository;


    @GetMapping("/patients/")
    public ResponseEntity<List<PatientsModel>> getAllPatients(){
        return ResponseEntity.status(HttpStatus.OK).body(patientRepository.findAll());
    }


    @GetMapping("/patients//{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable(value = "id") UUID id){
        Optional<PatientsModel> patientsRecordDTO = patientRepository.findById(id);

        if(patientsRecordDTO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(patientsRecordDTO);
    }






}
