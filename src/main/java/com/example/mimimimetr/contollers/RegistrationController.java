package com.example.mimimimetr.contollers;

import com.example.mimimimetr.domain.Role;
import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {

//
//        User userFromDb = userRepository.findByUserName(user.getUserName());
//
//        System.out.println(userFromDb.getUserName());
//        System.out.println(user.getUserName());

//        if (userFromDb != null) {
//            model.addAttribute("message", "test");
//            return "registration";
//        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:login";
    }
}
