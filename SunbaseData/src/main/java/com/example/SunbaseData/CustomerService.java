package com.example.SunbaseData;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public String addCustomer(Customer customer) throws Exception;

    public String deleteCustomer(Integer customerId) throws Exception;

    public String updateCustomer(Customer customer) throws Exception;

    public String getCustomerList() throws Exception;
    
}
