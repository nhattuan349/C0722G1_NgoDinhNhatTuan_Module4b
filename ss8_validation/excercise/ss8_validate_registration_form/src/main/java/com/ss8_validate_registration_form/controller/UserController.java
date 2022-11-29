package com.ss8_validate_registration_form.controller;

import com.ss8_validate_registration_form.dto.UserDto;
import com.ss8_validate_registration_form.model.User;
import com.ss8_validate_registration_form.service.IUserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5)Pageable pageable,
                                 @RequestParam(defaultValue = "") String firstName,
                                 @RequestParam(defaultValue = "") String lastName){
        ModelAndView modelAndView = new ModelAndView("views/user/list");
        modelAndView.addObject("users",userService.findByNameRegister(pageable, firstName, lastName));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("views/user/create");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Validated @ModelAttribute UserDto userDto,
                                    BindingResult bindingResult,
                                    @PageableDefault(value = 5) Pageable pageable,
                                    RedirectAttributes redirectAttributes
    ) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            ModelAndView modelAndView = new ModelAndView("views/user/create");
            return modelAndView;
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("redirect:/user");
            redirectAttributes.addFlashAttribute("message", "Add new succsessfuly");
            return modelAndView;
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        Optional<User> user = userService.findById(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user.get(), userDto);

        if (user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/user/edit");
            modelAndView.addObject("userDto", userDto);
            return modelAndView;
        } else {
            return new ModelAndView("views/user/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateUser(@Validated @ModelAttribute UserDto userDto,
                                      BindingResult bindingResult,
                                      @PageableDefault(value = 5) Pageable pageable,
                                      RedirectAttributes redirectAttributes
    ) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("views/user/edit");
            modelAndView.addObject("users", userService.findAll());
            return modelAndView;
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("redirect:/user");
            redirectAttributes.addFlashAttribute("message", "Edit new succsessfully");
            return  modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/user/delete");
            modelAndView.addObject("user", user.get());
            return modelAndView;

        } else {
            return new ModelAndView("views/user/error.404");
        }
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("user") User user) {
        userService.remove(user.getId());
        return "redirect:/user";
    }


}
