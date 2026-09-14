package org.example.medicineservice.controller;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.example.medicineservice.dto.CreateMedicineRequest;
import org.example.medicineservice.entity.Medicine;
import org.example.medicineservice.repository.MedicineRepository;
import org.example.medicineservice.service.MedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;
    private final MedicineRepository medicineRepository;

    public MedicineController(MedicineService medicineService, MedicineRepository medicineRepository) {
        this.medicineService = medicineService;
        this.medicineRepository = medicineRepository;
    }

    @GetMapping
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Medicine> create(@Valid @RequestBody CreateMedicineRequest request) {
        Medicine medicine = medicineService.create(request);
        return ResponseEntity.created(URI.create("/api/medicines/" + medicine.getId())).body(medicine);
    }
}
