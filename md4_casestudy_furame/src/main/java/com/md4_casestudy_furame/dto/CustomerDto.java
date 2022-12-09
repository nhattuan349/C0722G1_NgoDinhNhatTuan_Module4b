package com.md4_casestudy_furame.dto;

import com.md4_casestudy_furame.model.contract.Contract;
import com.md4_casestudy_furame.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank(message = "không thể để trống")
    private String name;
    @NotBlank(message = "không thể để trống")
    private String dateOfBirth;
    @NotBlank(message = "không thể để trống")
    private String gender;
    @NotBlank(message = "không thể để trống")
    private String idCard;
    @NotBlank(message = "không thể để trống")
    private String phoneNumber;
    @NotBlank(message = "không thể để trống")
    private String email;
    @NotBlank(message = "không thể để trống")
    private String address;
    private Integer status;
    private CustomerType customerType;
    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String dateOfBirth,
                       String gender, String idCard, String phoneNumber,
                       String email, String address, Integer status,
                       CustomerType customerType, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
