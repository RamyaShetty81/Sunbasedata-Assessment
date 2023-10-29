package com.example.SunbaseData;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // Make first_name and last_name mandatory
    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    String street;

    String address;

    String city;

    String state;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String phoneNo;
    
}
