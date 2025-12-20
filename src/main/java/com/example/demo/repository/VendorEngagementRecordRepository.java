public interface VendorEngagementRecordRepository extends JpaRepository<VendorEngagementRecord, Long> {
    List<VendorEngagementRecord> findByEmployeeId(Long id);
    List<VendorEngagementRecord> findByVendorId(Long id);
}
