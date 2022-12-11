package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.dto.CustomerDto;
import com.md4_casestudy_furame.model.customer.Customer;
import com.md4_casestudy_furame.service.customer.ICustomerService;
import com.md4_casestudy_furame.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView showListCustomer(@PageableDefault(value = 5)Pageable pageable,
                                         @RequestParam Optional<String> name,
                                         @RequestParam Optional<String> email,
                                         @RequestParam Optional<String> customerType){
        ModelAndView modelAndView = new ModelAndView("views/customer/list");
        modelAndView.addObject("name", name.orElse(""));
        modelAndView.addObject("email", email.orElse(""));
        modelAndView.addObject("customerType", customerType.orElse(""));
        modelAndView.addObject("customers", customerService.findAllCustomer(pageable, name.orElse(""), email.orElse(""), customerType.orElse("")));
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/show-form-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("views/customer/create");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                     BindingResult bindingResult,
                                     @PageableDefault(value = 5) Pageable pageable,
                                     RedirectAttributes redirectAttributes)
    {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("views/customer/create");
            modelAndView.addObject("customerTypes", customerTypeService.findAll());
            return modelAndView;
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setStatus(0);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            modelAndView.addObject("customerTypes", customerTypeService.findAll());
            redirectAttributes.addFlashAttribute("message","Add successful");
            return modelAndView;
        }
    }

    @GetMapping("/show-form-edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable int id){
        Optional<Customer> customer =customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(),customerDto);

        if(customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("views/customer/edit");
            modelAndView.addObject("customerTypes", customerTypeService.findAll());
            modelAndView.addObject("customerDto",customerDto);
            return modelAndView;
        }else {
            return  new ModelAndView("views/customer/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                       BindingResult bindingResult,
                                       @PageableDefault Pageable pageable,
                                       RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("views/customer/edit");
            return modelAndView;
        }else{
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customer.setStatus(0);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            redirectAttributes.addFlashAttribute("message","Add new successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id,
                               RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.remove(id);
        return modelAndView;

    }


}
