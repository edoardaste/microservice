package com.microservice.user.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record MedicalExamControlDTO(@NotBlank UUID pacientId,
        @NotBlank UUID doctorOrderExamId,
        @NotBlank String examType,
        @NotBlank Date requestedDateExam,
        @NotBlank Date examEndDate) {
}
