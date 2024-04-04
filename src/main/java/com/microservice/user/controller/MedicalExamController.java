package com.microservice.user.controller;

import com.microservice.user.dtos.MedicalExamControlRecordDTO;
import com.microservice.user.models.MedicalExamControlModel;
import com.microservice.user.repositories.MedicalExamRepository;
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
public class MedicalExamController {

    @Autowired
    MedicalExamRepository medicalExamRepository;

    @GetMapping("/medicalExam/")
    public ResponseEntity<List<MedicalExamControlModel>> getAllMedicalExams(){
        return ResponseEntity.status(HttpStatus.OK).body(medicalExamRepository.findAll());
    }

    @GetMapping("/medicalExam/{id}")
    public ResponseEntity<Object> getMedicalExamsById(@PathVariable(value="id") UUID id){
        Optional<MedicalExamControlModel> examControl = medicalExamRepository.findById(id);
        if(examControl.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medical Exam not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(examControl);
    }

    @PostMapping("/medicalExam/record")
    private ResponseEntity<MedicalExamControlModel> recordMedicalExam(@RequestBody MedicalExamControlRecordDTO
                                                                                  medicalExamControlDTO){
        var examModel = new MedicalExamControlModel();
        BeanUtils.copyProperties(examModel, medicalExamControlDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalExamRepository.save(examModel));

    }

    @GetMapping("/medicalExam/delete")
    public ResponseEntity<Object> deleteUserById (@PathVariable(value = "id") UUID id){
        Optional<MedicalExamControlModel> medControl = medicalExamRepository.findById(id);
        if(medControl.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        medicalExamRepository.delete(medControl.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }



}
