package org.challenge.termiVistingApplication.data.dtos;

import lombok.Data;

@Data
public class AddstaffRequest {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}
