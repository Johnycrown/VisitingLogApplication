package org.challenge.termiVistingApplication.service.visitorService;

import org.challenge.termiVistingApplication.data.dtos.VisitorRequestDto;
import org.challenge.termiVistingApplication.data.dtos.VisitorResponseDto;
import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.challenge.termiVistingApplication.data.repository.VisitorRepository;
import org.challenge.termiVistingApplication.exception.VisitorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class VisitorServiceImpl implements  VisitorService{
    @Autowired
    VisitorRepository visitorRepository;
    @Override
    public VisitorResponseDto createVisitor(VisitorRequestDto visitorRequestDto) {
        if (visitorRequestDto == null) throw new IllegalArgumentException("all  details must be provided to create staff to create visitor ");
        OrganisationVisitor newVisitor = OrganisationVisitor.builder()
                                                             .address(visitorRequestDto.getAddress())
                                                             .email(visitorRequestDto.getEmail())
                                                             .name(visitorRequestDto.getName())
                                                              .phoneNumber(visitorRequestDto.getPhoneNumber())
                                                               .build();
        visitorRepository.save(newVisitor);

        VisitorResponseDto  response = new VisitorResponseDto();
        response.setEmail(newVisitor.getEmail());
        response.setPhoneNumber(newVisitor.getPhoneNumber());
        response.setName(newVisitor.getName());


        return response;
    }

    @Override
    public OrganisationVisitor findVisitor(Long visitorId) throws VisitorNotFoundException {
        if(visitorId == null) throw  new IllegalArgumentException("the visitor Id must be provided ");
        Optional<OrganisationVisitor> visitor = visitorRepository.findById(visitorId);
        if(visitor.isEmpty()) throw new VisitorNotFoundException("the visitor with the id " + visitorId + "does not exist");
        OrganisationVisitor  queryVisitor = visitor.get();
        return queryVisitor;
    }

    @Override
    public List<OrganisationVisitor> findAllVisitor() {
        return visitorRepository.findAll();
    }
}
