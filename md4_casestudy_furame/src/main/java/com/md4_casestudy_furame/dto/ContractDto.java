package com.md4_casestudy_furame.dto;

import com.md4_casestudy_furame.model.contract.ContractDetail;
import com.md4_casestudy_furame.model.customer.Customer;
import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class ContractDto implements Validator {
    private Integer id;
    @NotBlank(message = "không thể để trống")
    private String start_date;
    @NotBlank(message = "không thể để trống")
    private String end_date;
    @Min(0)
    @NotNull
    private String deposit;
    private Integer status;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private Set<ContractDetail> contractDetails;
    private Double totalPrice;

    public ContractDto() {
    }

    public ContractDto(Integer id, String start_date, String end_date,
                       String deposit, Integer status, Employee employee,
                       Customer customer, Facility facility, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.deposit = deposit;
        this.status = status;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.contractDetails = contractDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void getTotalcost(){
        this.totalPrice = this.facility.getId().getCost;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
