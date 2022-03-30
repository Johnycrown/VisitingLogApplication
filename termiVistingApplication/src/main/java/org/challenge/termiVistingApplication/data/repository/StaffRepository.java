package org.challenge.termiVistingApplication.data.repository;

import org.challenge.termiVistingApplication.data.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long > {
   Optional<Staff> findByEmail(String email);
}
