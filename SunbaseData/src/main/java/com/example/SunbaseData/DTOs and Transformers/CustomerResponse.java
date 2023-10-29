package com.example.SunbaseData.DTOs;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponse {
    String firstName;

    String lastName;

    String address;

    String city;

    String state;

    String email;

    String phoneNo;
}
