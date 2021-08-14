package com.example.mimimimetr.contollers;

import com.example.mimimimetr.domain.Role;
import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {


        if (user.getUserName().equals(userService.findByUserName(user.getUserName()))) {
            model.addAttribute("message", "Error");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:login";
    }
}
