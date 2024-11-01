package com.example.resourceoptimizer.service;

import com.example.resourceoptimizer.StorageType;
import com.example.resourceoptimizer.repository.StorageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageTypeService {

    private final StorageTypeRepository storageTypeRepository;

    @Autowired
    public StorageTypeService(StorageTypeRepository storageTypeRepository) {
        this.storageTypeRepository = storageTypeRepository;
    }

    public Optional<StorageType> findByName(String name) {
        return storageTypeRepository.findByName(name);
    }

    public StorageType saveStorageType(StorageType storageType) {
        return storageTypeRepository.save(storageType);
    }

    public void deleteStorageType(String id) {
        storageTypeRepository.deleteById(id);
    }

    public Optional<StorageType> getStorageTypeById(String id) {
        return storageTypeRepository.findById(id);
    }
}
