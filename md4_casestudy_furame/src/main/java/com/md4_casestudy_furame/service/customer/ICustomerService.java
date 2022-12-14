package com.md4_casestudy_furame.service.customer;

import com.md4_casestudy_furame.model.customer.Customer;
import com.md4_casestudy_furame.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGeneralService<Customer> {

    Page<Customer> findAllCustomer(Pageable pageable,String name, String email,String customerType);
    Page<Customer> findAllCustomerAndFacility(Pageable pageable,String name,String email,String customerType);
}
