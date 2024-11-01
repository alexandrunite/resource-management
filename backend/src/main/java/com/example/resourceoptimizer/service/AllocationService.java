package com.example.resourceoptimizer.service;

import com.example.resourceoptimizer.AllocationResult;
import com.example.resourceoptimizer.Customer;
import com.example.resourceoptimizer.StorageType;
import com.example.resourceoptimizer.repository.CustomerRepository;
import com.example.resourceoptimizer.repository.StorageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AllocationService {

    private final CustomerRepository customerRepository;
    private final StorageTypeRepository storageTypeRepository;

    @Autowired
    public AllocationService(CustomerRepository customerRepository, StorageTypeRepository storageTypeRepository) {
        this.customerRepository = customerRepository;
        this.storageTypeRepository = storageTypeRepository;
    }

    public AllocationResult allocateResources() {
        List<Customer> customers = customerRepository.findAll();
        List<StorageType> storageTypes = storageTypeRepository.findAll();

        // Sort customers based on a priority score (higher priority for time sensitivity and cost efficiency)
        PriorityQueue<CustomerAllocation> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(CustomerAllocation::getPriorityScore).reversed());

        for (Customer customer : customers) {
            double priorityScore = calculatePriorityScore(customer);  // Higher score = higher priority
            priorityQueue.add(new CustomerAllocation(customer, priorityScore));
        }

        // Allocate storage based on priority
        AllocationResult result = new AllocationResult();
        Map<String, Double> allocations = new HashMap<>();

        for (StorageType storage : storageTypes) {
            double availableCapacity = storage.getCapacity();

            while (!priorityQueue.isEmpty() && availableCapacity > 0) {
                CustomerAllocation allocation = priorityQueue.poll();
                Customer customer = allocation.getCustomer();

                // Determine allocation amount based on customer needs and available capacity
                double allocationAmount = Math.min(customer.getDemand(), availableCapacity);

                allocations.put(customer.getId(), allocationAmount);
                availableCapacity -= allocationAmount;
            }
        }

        result.setAllocatedResources(allocations);
        return result;
    }

    // Helper method to calculate priority score for a customer
    private double calculatePriorityScore(Customer customer) {
        // Custom logic to calculate priority score, e.g., based on time sensitivity, cost efficiency, usage patterns
        double timeSensitivity = customer.getTimeSensitivity(); // Assume this is a value between 0 and 1
        double costEfficiency = customer.getCostEfficiency();   // Assume this is a value between 0 and 1

        // Prioritize time-sensitive and cost-efficient customers
        return (timeSensitivity * 0.7) + (costEfficiency * 0.3);
    }

    // Inner class to handle customer with priority score
    private static class CustomerAllocation {
        private final Customer customer;
        private final double priorityScore;

        public CustomerAllocation(Customer customer, double priorityScore) {
            this.customer = customer;
            this.priorityScore = priorityScore;
        }

        public Customer getCustomer() {
            return customer;
        }

        public double getPriorityScore() {
            return priorityScore;
        }
    }
}
