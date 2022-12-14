package com.md4_casestudy_furame.service.impl.customer;

import com.md4_casestudy_furame.model.customer.Customer;
import com.md4_casestudy_furame.repository.customer.ICustomerRepository;
import com.md4_casestudy_furame.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String name, String email, String customerType) {
        return customerRepository.findAllCustomer(pageable, name, email, customerType);
    }

    @Override
    public Page<Customer> findAllCustomerAndFacility(Pageable pageable, String name, String email, String customerType) {
        return customerRepository.findAllCustomerAndFacility(pageable, name, email, customerType);
    }
}
