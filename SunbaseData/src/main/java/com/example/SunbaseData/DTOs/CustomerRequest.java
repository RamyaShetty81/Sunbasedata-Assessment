package com.example.SunbaseData.DTOs;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequest{

    String firstName;

    String lastName;

    String street;

    String address;

    String city;

    String state;

    String email;

    String phoneNo;
}
