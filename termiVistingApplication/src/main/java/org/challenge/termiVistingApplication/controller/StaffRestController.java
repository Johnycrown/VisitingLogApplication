package org.challenge.termiVistingApplication.controller;

import org.challenge.termiVistingApplication.data.dtos.AddStaffResponse;
import org.challenge.termiVistingApplication.data.dtos.AddstaffRequest;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.challenge.termiVistingApplication.exception.UserNotFoundException;
import org.challenge.termiVistingApplication.service.staffService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/staff")
public class StaffRestController {
    @Autowired
  StaffService staffService;


    @PostMapping
    public ResponseEntity creatrStaff(@RequestBody AddstaffRequest addstaffRequest){
        try{
            AddStaffResponse staffCreated = staffService.createStaff(addstaffRequest);
            return ResponseEntity.ok().body(staffCreated);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public   ResponseEntity   getAllStaff(){
        List<Staff> allStaff = staffService.getAllStaff();
        return ResponseEntity.ok().body(allStaff);
    }
    @GetMapping("/staff{id}")
    public  ResponseEntity  getStaff(@PathVariable Long id){
        try{
            Staff staff = staffService.getStaff(id);
            return  ResponseEntity.ok().body(staff);
        } catch (UserNotFoundException e) {
          return  ResponseEntity.badRequest().body(e.getMessage())  ;
        }
    }


}
