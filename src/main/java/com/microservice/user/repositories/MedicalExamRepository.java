package com.microservice.user.repositories;

import com.microservice.user.models.MedicalExamControlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicalExamRepository extends JpaRepository<MedicalExamControlModel, UUID> {
}
