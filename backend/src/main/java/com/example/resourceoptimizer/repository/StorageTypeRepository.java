package com.example.resourceoptimizer.repository;

import com.example.resourceoptimizer.StorageType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StorageTypeRepository extends MongoRepository<StorageType, String> {
    Optional<StorageType> findByName(String name);
}
