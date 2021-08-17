package com.example.mimimimetr.contollers;


import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.dto.CatsListDTO;
import com.example.mimimimetr.service.CatService;
import com.example.mimimimetr.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final CatService catService;
    private final UserService userService;

    public MainController(CatService catService, UserService userService) {
        this.catService = catService;
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/end")
    public String end() {
        return "end";
    }

    @GetMapping("/top")
    public String topCats(Model model) {
        ControllerUtils controllerUtils = new ControllerUtils();
        model.addAttribute("catList", controllerUtils.sortCats(catService.findAll()));

        return "top";
    }

    @GetMapping("/vote")
    public String vote(Model model, HttpSession session) {

        ControllerUtils controllerUtils = new ControllerUtils();
        CatsListDTO catList = new CatsListDTO();

        CatDto catDto = new CatDto();
        CatDto catDto1 = new CatDto();

        controllerUtils.addCat(catList, catService);

        if (session.getAttribute("cats") instanceof CatsListDTO)
            if (session.getAttribute("cats") != null)
                catList = (CatsListDTO) session.getAttribute("cats");


        if (catList.getCats().size() == 0) {
            controllerUtils.updateChoice(session, userService);
            return "redirect:end";
        }

        if (userService.findUsersByCheckChoice(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()))
            return "redirect:end";

        catDto = controllerUtils.catAddAndRemove(catList, catDto);
        catDto1 = controllerUtils.catAddAndRemove(catList, catDto1);

        session.setAttribute("cats", catList);
        model.addAttribute("cat", catDto);
        model.addAttribute("cat1", catDto1);

        return "vote";
    }

    @PostMapping("/vote")
    public String postVote(@RequestParam(name = "id", required = false) int id) {

        List<CatDto> catDtoList = catService.findAll();

        catService.pointCounter(id, catDtoList.stream().filter(catDto -> catDto.getCatId() == id)
                .collect(Collectors.toList()).get(0).getCatPoint() + 1);

        return "redirect:vote";
    }

}
