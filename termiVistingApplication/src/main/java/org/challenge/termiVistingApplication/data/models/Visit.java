package org.challenge.termiVistingApplication.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;
    private String visitPurpose;
    @CreationTimestamp
    private LocalDateTime timeVisited;

    private Long visitorId ;

    private Long staffId;


}
