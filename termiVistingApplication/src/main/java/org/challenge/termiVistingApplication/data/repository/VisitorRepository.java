package org.challenge.termiVistingApplication.data.repository;

import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<OrganisationVisitor, Long> {
}
