package org.challenge.termiVistingApplication.data.dtos;

import lombok.Data;
import org.challenge.termiVistingApplication.data.models.OrganisationVisitor;
import org.challenge.termiVistingApplication.data.models.Staff;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;
@Data
public class VisitRequestDto {

    private String visitPurpose;
    @CreationTimestamp
    private LocalDateTime timeVisited;

    private Long VisitorId ;

    private Long staffId;
}
