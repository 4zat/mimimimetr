package com.example.mimimimetr.contollers;

import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String addUser(User user) {


        user.setActive(true);
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());

        userRepository.save(user);

        return "redirect:login";
    }
}
