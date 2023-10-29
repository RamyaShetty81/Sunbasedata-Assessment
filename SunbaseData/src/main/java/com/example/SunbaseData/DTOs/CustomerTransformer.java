package com.example.SunbaseData.DTOs;


import com.example.SunbaseData.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest)
    {
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .street(customerRequest.getStreet())
                .address(customerRequest.getAddress())
                .city(customerRequest.getCity())
                .state(customerRequest.getState())
                .email(customerRequest.getEmail())
                .phoneNo(customerRequest.getPhoneNo())
                
                .build();

    }

    public static CustomerResponse customerToCustomerResponse(Customer customer)
    {
        return CustomerResponse.builder()
                .firstName(customer.getFirstName())
                .lastName(customer. getLastName())    
                .address(customer.getAddress())
                .city(customer.getCity())
                .state(customer.getState())
                .email(customer.getEmail())
                .phoneNo(customer.getPhoneNo())
                
                .build();
    }

    public static Customer updateCustomerFromRequest(Customer customer, CustomerRequest customerRequest) {
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setStreet(customerRequest.getStreet());
        customer.setAddress(customerRequest.getAddress());
        customer.setCity(customerRequest.getCity());
        customer.setAddress(customerRequest.getAddress());
        customer .setEmail(customerRequest.getEmail());
          customer.setPhoneNo(customerRequest.getPhoneNo());
        return customer;
    }
}
