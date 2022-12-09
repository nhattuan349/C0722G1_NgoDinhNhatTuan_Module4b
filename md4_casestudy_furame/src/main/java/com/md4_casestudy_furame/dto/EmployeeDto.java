package com.md4_casestudy_furame.dto;

import com.md4_casestudy_furame.model.employee.Division;
import com.md4_casestudy_furame.model.employee.EducationDegree;
import com.md4_casestudy_furame.model.employee.Position;
import com.md4_casestudy_furame.model.user_role.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class EmployeeDto implements Validator{

    private Integer id;
    @NotBlank(message = "không thể để trống")
    private String name;
    @NotBlank(message = "không thể để trống")
    private String date;
    @NotBlank(message = "không thể để trống")
    private String idCard;
    @NotBlank(message = "không thể để trống")
    private String salary;
    @NotBlank(message = "không thể để trống")
    private String phone;
    @NotBlank(message = "không thể để trống")
    private String email;
    @NotBlank(message = "không thể để trống")
    private String address;
    private Integer status;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String date,
                       String idCard, String salary, String phone,
                       String email, String address, Integer status,
                       Position position, EducationDegree educationDegree,
                       Division division, User user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
