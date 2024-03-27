package com.microservice.user.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="medical_examination_control")
public class MedicalExamControlRecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID pacientId;
    private UUID doctorOrderExamId;
    private String examType;
    private Date requestedDateExam;
    private Date examEndDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPacientId() {
        return pacientId;
    }

    public void setPacientId(UUID pacientId) {
        this.pacientId = pacientId;
    }

    public UUID getDoctorOrderExamId() {
        return doctorOrderExamId;
    }

    public void setDoctorOrderExamId(UUID doctorOrderExamId) {
        this.doctorOrderExamId = doctorOrderExamId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public Date getRequestedDateExam() {
        return requestedDateExam;
    }

    public void setRequestedDateExam(Date requestedDateExam) {
        this.requestedDateExam = requestedDateExam;
    }

    public Date getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(Date examEndDate) {
        this.examEndDate = examEndDate;
    }
}
