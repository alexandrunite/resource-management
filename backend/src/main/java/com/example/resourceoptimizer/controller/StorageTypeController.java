package com.example.resourceoptimizer.controller;

import com.example.resourceoptimizer.StorageType;
import com.example.resourceoptimizer.service.StorageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/storage-types")
public class StorageTypeController {

    private final StorageTypeService storageTypeService;

    @Autowired
    public StorageTypeController(StorageTypeService storageTypeService) {
        this.storageTypeService = storageTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageType> getStorageTypeById(@PathVariable String id) {
        Optional<StorageType> storageType = storageTypeService.getStorageTypeById(id);
        return storageType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<StorageType> getStorageTypeByName(@PathVariable String name) {
        Optional<StorageType> storageType = storageTypeService.findByName(name);
        return storageType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StorageType> createStorageType(@RequestBody StorageType storageType) {
        StorageType createdStorageType = storageTypeService.saveStorageType(storageType);
        return ResponseEntity.ok(createdStorageType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorageType(@PathVariable String id) {
        storageTypeService.deleteStorageType(id);
        return ResponseEntity.noContent().build();
    }
}
