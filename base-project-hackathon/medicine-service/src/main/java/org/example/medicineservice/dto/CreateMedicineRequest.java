package org.example.medicineservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMedicineRequest(@NotBlank String name, @NotNull Long categoryId) {
}
