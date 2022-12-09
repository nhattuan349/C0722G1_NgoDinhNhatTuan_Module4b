package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.dto.UserDto;
import com.md4_casestudy_furame.dto.EmployeeDto;
import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.model.user_role.User;
import com.md4_casestudy_furame.service.employee.IDivisionService;
import com.md4_casestudy_furame.service.employee.IEducationDegreeService;
import com.md4_casestudy_furame.service.employee.IEmployeeService;
import com.md4_casestudy_furame.service.employee.IPositionService;
import com.md4_casestudy_furame.service.user.IUserService;
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

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ModelAndView showListEmployee(@PageableDefault(value = 5)Pageable pageable,
                                         @RequestParam(defaultValue = "") String name,
                                         @RequestParam(defaultValue = "") String division,
                                         @RequestParam(defaultValue = "") String position,
                                         @RequestParam(defaultValue = "") String educationDegree){
        ModelAndView modelAndView = new ModelAndView("views/employee/list");
        modelAndView.addObject("employees", employeeService.findByName(pageable, name, division, position, educationDegree));
        modelAndView.addObject("divisions",divisionService.findAll());
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("users",userService.findAll());
        modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
        return modelAndView;
    }

    @GetMapping("/show-form-create")
    public ModelAndView showCreateEmployeeForm(){
        ModelAndView modelAndView = new ModelAndView("views/employee/create");
        modelAndView.addObject("divisions",divisionService.findAll());
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
        modelAndView.addObject("users",userService.findAll());
        modelAndView.addObject("employeeDto",new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveEmployee(@Validated @ModelAttribute EmployeeDto employeeDto,
                                     BindingResult bindingResult,
                                     @PageableDefault(value = 5) Pageable pageable,
                                     RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("views/employee/create");
            modelAndView.addObject("divisions",divisionService.findAll());
            modelAndView.addObject("positions",positionService.findAll());
            modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
            modelAndView.addObject("users",userService.findAll());
            return modelAndView;
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employee.setStatus(0);
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("redirect:/employee");
            modelAndView.addObject("users",userService.findAll());
            redirectAttributes.addFlashAttribute("message", "Add succsessfully");
            return modelAndView;
        }
    }

}
