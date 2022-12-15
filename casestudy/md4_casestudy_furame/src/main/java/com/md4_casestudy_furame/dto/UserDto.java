package com.md4_casestudy_furame.dto;


import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.model.user_role.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.Set;

public class UserDto implements Validator {
    private Long id;

    private User user;

    private String username;

    private String password;

    private boolean isEnabled;

    private Set<Employee> employees;

    public UserDto() {
    }

    public UserDto(Long id, User user, String username,
                   String password, boolean isEnabled, Set<Employee> employees) {
        this.id = id;
        this.user = user;
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
