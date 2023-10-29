package com.example.SunbaseData;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SunbaseData.DTOs.CustomerRequest;
import com.example.SunbaseData.DTOs.CustomerResponse;

@Service
public interface CustomerService {

    public String addCustomer(CustomerRequest customerRequest) throws Exception;

    public String deleteCustomer(Integer customerId) throws Exception;

    public String updateCustomer(Integer id, CustomerRequest customerRequest) throws Exception;

    public List<CustomerResponse> getCustomerList() throws Exception;
    
}
