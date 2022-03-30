package org.challenge.termiVistingApplication.service.visitService;

import org.challenge.termiVistingApplication.data.dtos.VisitRequestDto;
import org.challenge.termiVistingApplication.data.models.Visit;
import org.challenge.termiVistingApplication.data.repository.VisitRepository;
import org.challenge.termiVistingApplication.email.EmailUtil;
import org.challenge.termiVistingApplication.email.EmailUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitiServiceImpl implements  VisitService{
    @Autowired
    VisitRepository visitRepository;
    @Autowired
    EmailUtil emailUtil;

    @Override
    public String createVisit(VisitRequestDto visitRequestDto) {
        if(visitRequestDto == null) throw new IllegalArgumentException("the Details must be provided to create visit  ");
       Visit newVisit = Visit.builder()
                             .visitPurpose(visitRequestDto.getVisitPurpose())
                             .staffId(visitRequestDto.getStaffId())
                             .visitorId(visitRequestDto.getVisitorId())
                             .build();
           visitRepository.save(newVisit);

           emailUtil.sendEmailToStaff("oladejijohn60@gmail.com", "New Visit", "a new visit has been aded to the log");


        return "visit is successfully created";
    }
}
