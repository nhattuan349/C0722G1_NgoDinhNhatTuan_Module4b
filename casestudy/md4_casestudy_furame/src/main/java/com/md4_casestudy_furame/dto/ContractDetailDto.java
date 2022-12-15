package com.md4_casestudy_furame.dto;

import com.md4_casestudy_furame.model.contract.AttachFacility;
import com.md4_casestudy_furame.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDetailDto implements Validator {

    private Integer id;
    private Double quanlity;
    private AttachFacility attachFacility;
    private Contract contract;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, Double quanlity,
                             AttachFacility attachFacility,
                             Contract contract) {
        this.id = id;
        this.quanlity = quanlity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Double quanlity) {
        this.quanlity = quanlity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
