package com.microservice.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record UsersRecordDTO(@NotBlank String name,
                             @NotBlank String address,
                             @NotBlank String function,
                             @NotEmpty Integer phoneNumber) {
}
