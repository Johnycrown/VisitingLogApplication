package org.challenge.termiVistingApplication.service.staffService;

import org.challenge.termiVistingApplication.data.dtos.AddStaffResponse;
import org.challenge.termiVistingApplication.data.dtos.AddstaffRequest;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.data.repository.StaffRepository;
import org.challenge.termiVistingApplication.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts = {"/dB/insert.sql/"})
class StaffServiceImplTest {
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StaffService staffService;

    @Test
    void findAllStaff(){
      List<Staff> staffList =  staffService.getAllStaff();
      assertThat(staffList).isNotNull();
      assertThat(staffList.size()).isEqualTo(4);

    }
    @Test
    void findStaffByID() throws UserNotFoundException {

        Staff staff = staffService.getStaff(21l);
        assertThat(staff).isNotNull();
        assertThat(staff.getName()).isEqualTo("Isreal");
        assertThat(staff.getEmail()).isEqualTo("ade@gmail.com");
        assertThat(staff.getPhoneNumber()).isEqualTo("0803432");
    }

    @Test
    void createStaff(){
        AddstaffRequest createStaffRequest = new AddstaffRequest();
        createStaffRequest.setEmail("Sola@gmail.com");
        createStaffRequest.setAddress("alagbole lagos");
        createStaffRequest.setName("Bisola");
        createStaffRequest.setPhoneNumber("08034256152");
        AddStaffResponse newStaff = staffService.createStaff(createStaffRequest);
        assertThat(newStaff).isNotNull();
        assertThat(newStaff.getName()).isEqualTo("Bisola");

    }


}