package org.challenge.termiVistingApplication.service.staffService;

import org.challenge.termiVistingApplication.data.dtos.AddStaffResponse;
import org.challenge.termiVistingApplication.data.dtos.AddstaffRequest;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.data.repository.StaffRepository;
import org.challenge.termiVistingApplication.exception.UserNotFoundException;
import org.challenge.termiVistingApplication.service.staffService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StaffServiceImpl implements StaffService {


    @Autowired
    StaffRepository staffRepository;




    @Override
    public AddStaffResponse createStaff(AddstaffRequest addstaffRequest) {
        if(addstaffRequest == null) throw new IllegalArgumentException("all  details must be provided to create staff ");
        Staff newStaff = Staff.builder()
                              .address(addstaffRequest.getAddress())
                              .email(addstaffRequest.getEmail())
                               .name(addstaffRequest.getName())
                               .phoneNumber(addstaffRequest.getPhoneNumber())
                                .build();

        staffRepository.save(newStaff);


        AddStaffResponse response = new AddStaffResponse();
        response.setEmail(newStaff.getEmail());
        response.setName(newStaff.getName());
        response.setPhoneNumber(newStaff.getPhoneNumber());


        return response;
    }

    @Override
    public Staff getStaff(Long staffId) throws UserNotFoundException {
        if(staffId == null) throw  new IllegalArgumentException("the staff id must be provided to get staff");
        Optional<Staff> staff = staffRepository.findById(staffId);
        if(staff.isEmpty()) throw new UserNotFoundException("the staff with the id  " + staffId + " does not exist");
        Staff   queryStaff = staff.get();

        return queryStaff;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
}
