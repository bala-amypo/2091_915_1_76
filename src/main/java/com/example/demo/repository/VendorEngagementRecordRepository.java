package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.model.VendorEngagementRecord;

@Repository
public interface VendorEngagementRecordRepository extends JpaRepository<VendorEngagementRecord, Long> {
    List<VendorEngagementRecord> findByEmployeeId(Long id);
    List<VendorEngagementRecord> findByVendorId(Long id);
}
