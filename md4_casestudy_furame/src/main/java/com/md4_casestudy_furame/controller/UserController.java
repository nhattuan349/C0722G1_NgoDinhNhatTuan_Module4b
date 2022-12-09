package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.dto.UserDto;
import com.md4_casestudy_furame.model.user_role.User;
import com.md4_casestudy_furame.service.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ModelAndView showlist(){
        ModelAndView modelAndView = new ModelAndView("views/myLogin");
        return modelAndView;
    }

    @GetMapping("show-form-create")
    public ModelAndView showCreateUserForm(){
        ModelAndView modelAndView = new ModelAndView("views/user/create");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Validated @ModelAttribute UserDto userDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("views/user/create");
            return modelAndView;
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            user.setEnabled(true);
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("message","Tạo tài khoản thành công");
            return modelAndView;
        }
    }
}
