package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.model.contract.AttachFacility;
import com.md4_casestudy_furame.model.contract.ContractDetail;
import com.md4_casestudy_furame.model.customer.Customer;
import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.model.facility.Facility;
import com.md4_casestudy_furame.service.contract.IAttachFacilityService;
import com.md4_casestudy_furame.service.contract.IContractDetailService;
import com.md4_casestudy_furame.service.contract.IContractService;
import com.md4_casestudy_furame.service.customer.ICustomerService;
import com.md4_casestudy_furame.service.employee.IEmployeeService;
import com.md4_casestudy_furame.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("attachFacilities")
    public List<AttachFacility> getListAttachFacility() {
        return attachFacilityService.findAll();
    }

    @ModelAttribute("contractDetails")
    public List<ContractDetail> getListContractDetail(){
        return contractDetailService.findAll();
    }

    @ModelAttribute("facilities")
    public List<Facility> getListFacility(){
        return facilityService.findAll();
    }

    @ModelAttribute("employees")
    public List<Employee> getListEmployee(){
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> getListCustomer(){
        return customerService.findAll();
    }

    @GetMapping("")
    public ModelAndView showListContract(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("views/contract/list");

        return modelAndView;
    }

}
