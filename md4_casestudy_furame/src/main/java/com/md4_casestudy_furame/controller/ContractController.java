package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.dto.ContractDetailDto;
import com.md4_casestudy_furame.dto.ContractDto;
import com.md4_casestudy_furame.model.contract.AttachFacility;
import com.md4_casestudy_furame.model.contract.Contract;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
        Page<Contract> contractPage = contractService.findAllContract(pageable);
        Page<ContractDto> contractDtoPage = contractPage.map(new Function<Contract, ContractDto>() {
            @Override
            public ContractDto apply(Contract contract) {
                ContractDto contractDto = new ContractDto();
                BeanUtils.copyProperties(contract, contractDto);
                contractDto.getTotalcost();
                return contractDto;
            }
        });
        modelAndView.addObject("contracts", contractDtoPage);
        modelAndView.addObject("contractDetail",new ContractDetail());
        modelAndView.addObject("contractDto", new ContractDto());

        LocalDate minAge = LocalDate.now();
        modelAndView.addObject("minAge", minAge);

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView showFormCreate(@ModelAttribute ContractDto contractDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("redirect:/contract");
            return modelAndView;
        }else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contract.setStatus(0);
            contractService.save(contract);
            ModelAndView modelAndView = new ModelAndView(("redirect:/contract"));
          redirectAttributes.addFlashAttribute("message", "Add successfylly");
            return modelAndView;
        }

    }

    @PostMapping("/add-contract-detail")
    public ModelAndView saveDetail(@ModelAttribute ContractDetail contractDetail,
                                                RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");
        return modelAndView;
    }


}
