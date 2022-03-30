package org.challenge.termiVistingApplication.controller;

import org.challenge.termiVistingApplication.data.dtos.VisitorRequestDto;
import org.challenge.termiVistingApplication.data.dtos.VisitorResponseDto;
import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.challenge.termiVistingApplication.data.repository.VisitorRepository;
import org.challenge.termiVistingApplication.exception.VisitorNotFoundException;
import org.challenge.termiVistingApplication.service.visitorService.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visitor")
public class VisitorRestController {
       @Autowired
    VisitorService visitorService;


       @PostMapping
    public ResponseEntity createVisitor(@RequestBody VisitorRequestDto visitorRequestDto){
           try{
               VisitorResponseDto response = visitorService.createVisitor(visitorRequestDto);
               return ResponseEntity.ok().body(response);
           }
           catch (IllegalArgumentException  e){
               return ResponseEntity.badRequest().body(e.getMessage());
           }
       }
       @GetMapping
       public ResponseEntity  getAllVisitors(){
           List<OrganisationVisitor> visitors = visitorService.findAllVisitor();
           return ResponseEntity.ok().body(visitors);
       }
       @GetMapping("/{id}")
     public  ResponseEntity getVisitor(@PathVariable Long id){
           try{
               OrganisationVisitor visitor = visitorService.findVisitor(id);
               return  ResponseEntity.ok().body(visitor);
           } catch (VisitorNotFoundException e) {
               return ResponseEntity.badRequest().body(e.getMessage());



           }
       }
}
