package com.microservice.user.repositories;

import com.microservice.user.models.PatientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientsRepository extends JpaRepository<PatientsModel, UUID> {
}
