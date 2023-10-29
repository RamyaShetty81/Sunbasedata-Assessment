package com.example.SunbaseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/customer")
public class CustomerController{

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest)
    {
        try {
            String message = customerService.addCustomer(customerRequest);
            return new ResponseEntity(message, HttpStatus.CREATED);
        } catch (FirstNameOrLastNameNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        try {
            String message = customerService.deleteCustomer(id);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (IdNotPresentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomerByEmail(@PathVariable Integer id,
                                                        @RequestBody CustomerRequest customerRequest) {
        try {
            String message = customerService.updateCustomer(customerRequest);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (IdNotPresentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        try {
            List<CustomerResponse> customerResponses = customerService.getCustomerList();
            return ResponseEntity.status(HttpStatus.OK).body(customerResponses);
        } catch (NoCustomerException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }


}