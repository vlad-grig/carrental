package com.sda.carrentalservice.service;

import com.sda.carrentalservice.dto.CustomerDTO;
import com.sda.carrentalservice.entity.Customer;
import com.sda.carrentalservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customerRepository.save(customer);
    }

    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setEmail(customer.getEmail());
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return customer;
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteCustomerById(Long id) {
        this.findCustomerById(id);
        customerRepository.deleteById(id);
    }
}
