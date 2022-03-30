package org.challenge.termiVistingApplication.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrganisationVisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long visitorId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Authority authority;
}
