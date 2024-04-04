package com.microservice.user.controller;

import com.microservice.user.dtos.PatientsRecordDTO;
import com.microservice.user.models.PatientsModel;
import com.microservice.user.repositories.PatientsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/patients/s{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable(value = "id") UUID id){
        Optional<PatientsModel> patientsModel = patientRepository.findById(id);

        if(patientsModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(patientsModel);
    }

    @PostMapping("/patients/record")
    public ResponseEntity<PatientsModel> addPatients(@RequestBody PatientsRecordDTO patientsRecordDTO){
        var patientModel = new PatientsModel();
        BeanUtils.copyProperties(patientsRecordDTO, patientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientRepository.save(patientModel));
    }

    @GetMapping("/patients/delete")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") UUID id){
        Optional<PatientsModel> patientModel = patientRepository.findById(id);

        if(patientModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found!");
        }
        patientRepository.delete(patientModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Patient deleted");


    }






}
