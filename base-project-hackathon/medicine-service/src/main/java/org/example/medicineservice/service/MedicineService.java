package org.example.medicineservice.service;

import feign.FeignException;
import org.example.medicineservice.client.CategoryClient;
import org.example.medicineservice.dto.CreateMedicineRequest;
import org.example.medicineservice.entity.Medicine;
import org.example.medicineservice.repository.MedicineRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final CategoryClient categoryClient;

    public MedicineService(MedicineRepository medicineRepository, CategoryClient categoryClient) {
        this.medicineRepository = medicineRepository;
        this.categoryClient = categoryClient;
    }

    public Medicine create(CreateMedicineRequest request) {
        try {
            categoryClient.getById(request.categoryId());
        } catch (FeignException.NotFound exception) {
            throw new CategoryNotFoundException(request.categoryId());
        }
        return medicineRepository.save(new Medicine(request.name(), request.categoryId()));
    }
}
