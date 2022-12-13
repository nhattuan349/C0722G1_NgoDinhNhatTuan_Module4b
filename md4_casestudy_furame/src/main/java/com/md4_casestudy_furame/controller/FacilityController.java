package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.dto.FacilityDto;
import com.md4_casestudy_furame.model.facility.Facility;
import com.md4_casestudy_furame.service.facility.IFacilityService;
import com.md4_casestudy_furame.service.facility.IFacilityTypeService;
import com.md4_casestudy_furame.service.facility.IRentTypeService;
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
@RequestMapping("facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;


    @GetMapping("")
    public ModelAndView showListFacility(@PageableDefault(value = 5) Pageable pageable,
                                         @RequestParam Optional<String> name,
                                         @RequestParam Optional<String> facilityType,
                                         @RequestParam Optional<String> rentType) {
        ModelAndView modelAndView = new ModelAndView("views/facility/list");
        modelAndView.addObject("name", name.orElse(""));
        modelAndView.addObject("facilityType", facilityType.orElse(""));
        modelAndView.addObject("rentType", rentType.orElse(""));
        modelAndView.addObject("facilities", facilityService.findByNameFacility(pageable, name.orElse(""), facilityType.orElse(""), rentType.orElse("")));
        modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/show-form-create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/facility/create");
        modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        modelAndView.addObject("facilityDto", new FacilityDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                                     BindingResult bindingResult,
                                     @PageableDefault(value = 5) Pageable pageable,
                                     RedirectAttributes redirectAttributes
    ) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/facility/create");
            modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
            modelAndView.addObject("rentTypes", rentTypeService.findAll());
            return modelAndView;
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facility.setStatus(0);
            facilityService.save(facility);
            ModelAndView modelAndView = new ModelAndView("redirect:/facility");
            redirectAttributes.addFlashAttribute("message", "Add new successfully!");
            modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
            modelAndView.addObject("rentTypes", rentTypeService.findAll());
            return modelAndView;
        }
    }

    @GetMapping("show-form-edit/{id}")
    public ModelAndView showEditFacility(@PathVariable int id) {
        Optional<Facility> facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility.get(), facilityDto);
        if (facility.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/facility/edit");
            modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
            modelAndView.addObject("rentTypes", rentTypeService.findAll());
            modelAndView.addObject("facilityDto", facilityDto);
            return modelAndView;
        } else
            return new ModelAndView("views/facility/error.404");

    }

    @PostMapping("/edit")
    public ModelAndView updateFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                                       BindingResult bindingResult,
                                       @PageableDefault(value = 5) Pageable pageable,
                                       RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/facility/edit");
            modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
            modelAndView.addObject("rentTypes", rentTypeService.findAll());
            return modelAndView;
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facility.setStatus(0);
            facilityService.save(facility);
            ModelAndView modelAndView = new ModelAndView("redirect:/facility");
            redirectAttributes.addFlashAttribute("message", "edit successfully");
            return modelAndView;
        }

    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id,
                               RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/facility");
        facilityService.remove(id);
        return modelAndView;
    }



}
