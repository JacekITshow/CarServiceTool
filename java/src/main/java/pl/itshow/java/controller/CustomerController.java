package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.dto.CustomerDto;
import pl.itshow.java.entity.Customer;
import pl.itshow.java.repository.CustomerDaoImpl;
import pl.itshow.java.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/male")
    List<CustomerDto> getAllMaleCustomers() {
        return customerDaoImpl.findCustomersByGender("Male");
    }

    @GetMapping("/{customerId}")
    Customer getCustomerById (@PathVariable int customerId) {
        return customerRepository.findById(customerId);
    }

    @GetMapping("/all")
    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
