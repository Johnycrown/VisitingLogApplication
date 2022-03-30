package org.challenge.termiVistingApplication.service.staffService;

import org.challenge.termiVistingApplication.data.dtos.AddStaffResponse;
import org.challenge.termiVistingApplication.data.dtos.AddstaffRequest;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.exception.UserNotFoundException;

import java.util.List;

public interface StaffService {
    AddStaffResponse createStaff(AddstaffRequest addstaffRequest);
    Staff getStaff(Long staffId) throws UserNotFoundException;
    List<Staff> getAllStaff();
}
