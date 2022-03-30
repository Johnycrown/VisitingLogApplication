package org.challenge.termiVistingApplication.data.repository;

import org.challenge.termiVistingApplication.data.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
