package com.example.SunbaseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequest customerRequest) 
    {
        if (customerRequest.getFirstName() == null || customerRequest.getLastName() == null) {
           throw new FirstNameOrLastNameNotFoundException("First Name or Last Name is missing");
        }

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        customerRepository.save(customer);
        return "Successfully Created";
    }

    public String deleteCustomer(Integer customerId) 
    {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IdNotPresentException("Customer not found"));

        customerRepository.delete(customer);
        return "Customer deleted successfully";
    }

    public String updateCustomer(Integer id, CustomerRequest customerRequest)
    {
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new IdNotPresentException("Customer not found");
        }

        Customer updatedCustomer = CustomerTransformer.updateCustomerFromRequest(customer, customerRequest);
        customerRepository.save(updatedCustomer);

        return "Customer updated successfully";
    } 

    public List<CustomerResponse> getCustomerList() 
    {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new NoCustomerException("No customers found");
        }

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    
}