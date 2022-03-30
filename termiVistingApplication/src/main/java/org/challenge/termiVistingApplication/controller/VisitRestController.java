package org.challenge.termiVistingApplication.controller;


import org.challenge.termiVistingApplication.data.dtos.VisitRequestDto;
import org.challenge.termiVistingApplication.service.visitService.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/visit")
public class VisitRestController {
    @Autowired
    VisitService visitService;


    @PostMapping
    public ResponseEntity createVisit(@RequestBody VisitRequestDto visitRequestDto){
        try{
        String message = visitService.createVisit(visitRequestDto);
        return ResponseEntity.ok().body(message); }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
