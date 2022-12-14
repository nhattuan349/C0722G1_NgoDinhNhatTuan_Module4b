package com.md4_casestudy_furame.repository.customer;

import com.md4_casestudy_furame.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = " select c.* " +
            "from `customer` c " +
            "join `customer_type` ct on c.customer_type_id = ct.id " +
            "where c.name like concat('%', :name,'%') " +
            "and c.email like concat('%', :email,'%') " +
            "and ct.name like concat('%', :customerType,'%') " +
            "and c.status=0 " +
            "order by c.id desc ", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable,
                                   @Param("name") String name,
                                   @Param("email") String email,
                                   @Param("customerType") String customerType);


    @Modifying
    @Transactional
    @Query(value = "select `customer`  set status=1 where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = " select c.* " +
            "from `customer` c " +
            "join `customer_type` ct on c.customer_type_id = ct.id " +
            "left join `contract` ctr on c.id= ctr.customer_id " +
            "where c.name like concat('%', :name,'%') " +
            "and c.email like concat('%', :email,'%') " +
            "and ct.name like concat('%', :customerType,'%') " +
            "and c.status=0 " +
            "and curdate()<ctr.end_date " +
            "order by c.id desc ", nativeQuery = true)
    Page<Customer> findAllCustomerAndFacility(Pageable pageable,
                                   @Param("name") String name,
                                   @Param("email") String email,
                                   @Param("customerType") String customerType);
}
