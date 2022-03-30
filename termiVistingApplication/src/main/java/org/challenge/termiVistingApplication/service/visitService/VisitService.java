package org.challenge.termiVistingApplication.service.visitService;

import org.challenge.termiVistingApplication.data.dtos.VisitRequestDto;

public interface VisitService {
    String createVisit(VisitRequestDto visitRequestDto);
}
