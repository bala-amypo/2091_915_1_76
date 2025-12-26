package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engagements")
public class VendorEngagementController {

    private final VendorEngagementService service;

    public VendorEngagementController(VendorEngagementService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public VendorEngagementRecord add(@RequestBody VendorEngagementRecord record) {
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

    @GetMapping("/all")
    public List<VendorEngagementRecord> getAll() {
        return service.getAllEngagements();
    }
}
