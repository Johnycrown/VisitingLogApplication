package org.challenge.termiVistingApplication.service.visitorService;

import org.challenge.termiVistingApplication.data.dtos.VisitorRequestDto;
import org.challenge.termiVistingApplication.data.dtos.VisitorResponseDto;
import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.challenge.termiVistingApplication.exception.VisitorNotFoundException;

import java.util.List;

public interface VisitorService {
    VisitorResponseDto createVisitor(VisitorRequestDto visitorRequestDto);
    OrganisationVisitor findVisitor(Long visitorId) throws VisitorNotFoundException;
    List<OrganisationVisitor>   findAllVisitor();
}
