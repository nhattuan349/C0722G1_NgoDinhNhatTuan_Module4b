package com.md4_casestudy_furame.dto;

import com.md4_casestudy_furame.model.contract.Contract;
import com.md4_casestudy_furame.model.facility.FacilityType;
import com.md4_casestudy_furame.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class FacilityDto implements Validator {

    private Integer id;
    @NotBlank(message = "không thể để trống")
    private String name;
    @NotBlank(message = "không thể để trống")
    private String area;
    @NotBlank(message = "không thể để trống")
    private String cost;
    @NotBlank(message = "không thể để trống")
    private String maxPeople;
    @NotBlank(message = "không thể để trống")
    private String standardRoom;
    @NotBlank(message = "không thể để trống")
    private String descriptionOtherConvenience;
    @NotBlank(message = "không thể để trống")
    private String poolArea;
    @NotBlank(message = "không thể để trống")
    private String numberOfFloors;
    @NotBlank(message = "không thể để trống")
    private String facilityFree;
    private Integer status;
    private FacilityType facilityType;
    private RentType rentType;
    private Set<Contract> contracts;


    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, String area,
                       String cost, String maxPeople, String standardRoom,
                       String descriptionOtherConvenience, String poolArea,
                       String numberOfFloors, String facilityFree, Integer status,
                       FacilityType facilityType, RentType rentType, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.status = status;
        this.facilityType = facilityType;
        this.rentType = rentType;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
