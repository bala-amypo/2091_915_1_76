package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;

import java.util.List;

@Service
public class VendorEngagementServiceImpl
        implements VendorEngagementService {

    private final VendorEngagementRecordRepository repo;
    private final PersonProfileRepository personRepo;

    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository repo,
            PersonProfileRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    public VendorEngagementRecord addEngagement(VendorEngagementRecord r) {
        if (personRepo.findById(r.getEmployeeId()).isEmpty()
                || personRepo.findById(r.getVendorId()).isEmpty())
            throw new ApiException("person not found");
        return repo.save(r);
    }

    public List<VendorEngagementRecord> getEngagementsByEmployee(Long id) {
        return repo.findByEmployeeId(id);
    }

    public List<VendorEngagementRecord> getEngagementsByVendor(Long id) {
        return repo.findByVendorId(id);
    }

    public List<VendorEngagementRecord> getAllEngagements() {
        return repo.findAll();
    }
}
