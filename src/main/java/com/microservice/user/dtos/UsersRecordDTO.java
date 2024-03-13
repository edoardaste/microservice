package com.microservice.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsersRecordDTO(@NotBlank String name, @NotNull String address) {
}
