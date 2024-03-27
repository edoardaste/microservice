package com.microservice.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record PatientsRecordDTO(@NotBlank String name,
                                @NotBlank String address,
                                @NotEmpty Integer phoneNumber,
                                @NotBlank String email,
                                @NotBlank String cpf
                                ) {
}
