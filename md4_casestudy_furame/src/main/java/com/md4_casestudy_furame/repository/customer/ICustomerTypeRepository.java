package com.md4_casestudy_furame.repository.customer;

import com.md4_casestudy_furame.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
