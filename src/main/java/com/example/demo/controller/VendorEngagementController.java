package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;

@RestController
@RequestMapping("/engagements")
public class VendorEngagementController {

    @Autowired
    VendorEngagementService service;

    @PostMapping("/add")
    public VendorEngagementRecord addEngagement(
            @RequestBody VendorEngagementRecord record) {
        return service.addEngagement(record);
    }

    @GetMapping("/employee/{employeeId}")
    public List<VendorEngagementRecord> getByEmployee(
            @PathVariable Long employeeId) {
        return service.getEngagementsByEmployee(employeeId);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorEngagementRecord> getByVendor(
            @PathVariable Long vendorId) {
        return service.getEngagementsByVendor(vendorId);
    }

    @GetMapping("/getAll")
    public List<VendorEngagementRecord> getAll() {
        return service.getAllEngagements();
    }
}
