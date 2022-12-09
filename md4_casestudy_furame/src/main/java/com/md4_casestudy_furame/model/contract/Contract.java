package com.md4_casestudy_furame.model.contract;

import com.md4_casestudy_furame.model.customer.Customer;
import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String start_date;
    private String end_date;
    private String deposit;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id",referencedColumnName = "id")
    private Facility facility;
    public Contract() {
    }

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    public Contract(Integer id, String start_date, String end_date,
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
}
