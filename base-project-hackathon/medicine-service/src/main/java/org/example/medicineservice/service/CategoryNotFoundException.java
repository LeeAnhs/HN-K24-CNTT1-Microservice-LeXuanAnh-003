package org.example.medicineservice.service;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long categoryId) {
        super("Category not found: " + categoryId);
    }
}
