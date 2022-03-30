package org.challenge.termiVistingApplication.service.visitorService;

import org.challenge.termiVistingApplication.data.dtos.AddStaffResponse;
import org.challenge.termiVistingApplication.data.dtos.AddstaffRequest;
import org.challenge.termiVistingApplication.data.dtos.VisitorRequestDto;
import org.challenge.termiVistingApplication.data.dtos.VisitorResponseDto;
import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.data.repository.StaffRepository;
import org.challenge.termiVistingApplication.data.repository.VisitRepository;
import org.challenge.termiVistingApplication.exception.UserNotFoundException;
import org.challenge.termiVistingApplication.exception.VisitorNotFoundException;
import org.challenge.termiVistingApplication.service.staffService.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts = {"/dB/insert.sql/"})
class VisitorServiceImplTest {

    @Autowired
    VisitRepository visitRepository;
    @Autowired
    VisitorService visitorService;

    @Test
    void findAllVisitors(){
        List<OrganisationVisitor> staffList =  visitorService.findAllVisitor();
        assertThat(staffList).isNotNull();
        assertThat(staffList.size()).isEqualTo(4);

    }
    @Test
    void findStaffByID() throws UserNotFoundException, VisitorNotFoundException {

        OrganisationVisitor visitor = visitorService.findVisitor(21l);
        assertThat(visitor).isNotNull();
        assertThat(visitor.getName()).isEqualTo("JIDE");
        assertThat(visitor.getEmail()).isEqualTo("ade@gmail.com");
        assertThat(visitor.getPhoneNumber()).isEqualTo("0803432");
    }

    @Test
    void createStaff(){
        VisitorRequestDto createVistorfRequest = new VisitorRequestDto();
        createVistorfRequest .setEmail("oler@gmail.com");
        createVistorfRequest .setAddress("alagbole lagos");
        createVistorfRequest .setName("Yetunde");
        createVistorfRequest .setPhoneNumber("08034256152");
        VisitorResponseDto newVisitor = visitorService.createVisitor(createVistorfRequest );
        assertThat(newVisitor).isNotNull();
        assertThat(newVisitor.getName()).isEqualTo("Yetunde");

    }

}