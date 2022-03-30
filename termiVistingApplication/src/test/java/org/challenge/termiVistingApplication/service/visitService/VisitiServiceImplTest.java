package org.challenge.termiVistingApplication.service.visitService;

import org.challenge.termiVistingApplication.data.dtos.*;
import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.data.models.Visit;
import org.challenge.termiVistingApplication.service.staffService.StaffService;
import org.challenge.termiVistingApplication.service.visitorService.VisitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Sql(scripts = {"/dB/insert.sql/"})
class VisitiServiceImplTest {
    @Autowired
    VisitService visitService;

    @Autowired
    VisitorService visitorService;

    @Autowired
    StaffService staffService;



    @Test
    void createVisitTest(){

        OrganisationVisitor newVisitor = OrganisationVisitor.builder()
                .address("alagbole lagos")
                .email("oler@gmail.com")
                .name("Yetunde")
                .phoneNumber("08034256152")
                .visitorId(1l)
                .build();



        Staff newStaff = Staff.builder()
                .address("alagbole lagos")
                .email("Sola@gmail.com")
                .name("Bisola")
                .phoneNumber("08034256152")
                .id(1L)
                .build();



        Visit visitRequestDto = new Visit();
        visitRequestDto.setVisitPurpose("offical");
        visitRequestDto.setStaffId(newStaff.getId());
        visitRequestDto.setVisitorId(1L);

        assertThat(visitRequestDto).isNotNull();
        assertThat(visitRequestDto.getStaffId()).isEqualTo(newStaff.getId());
       assertThat(visitRequestDto.getVisitorId()).isEqualTo(newVisitor.getVisitorId());




    }

}