package com.example.mimimimetr.contollers;


import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.dto.CatsListDTO;
import com.example.mimimimetr.service.CatService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private final CatService catService;

    public MainController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/top")
    public String topCats(Model model) {
        List<CatDto> list = catService.findAll();


        model.addAttribute("catList", list);

        return "top";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/vote")
    public String vote(Model model, HttpSession session) {

        CatsListDTO catList = new CatsListDTO();

        if (catList.getCats() == null) {
            catList.setCats(catService.findAll());
        }

        if (session.getAttribute("cats") instanceof CatsListDTO)
            if (session.getAttribute("cats") != null)
                catList = (CatsListDTO) session.getAttribute("cats");


        session.setAttribute("cats", catList);
        if (catList.getCats().size() == 0) {
            return "index";
        }

        Integer count = (Integer) session.getAttribute("count");
        Integer count1 = (Integer) session.getAttribute("count1");

        CatDto catDto;
        CatDto catDto1;

        if ((Integer) session.getAttribute("count") > 6) {
            return "redirect:/top";
        }

        if (count == null || count1 == null) {
            count = 0;
            count1 = 1;
            session.setAttribute("count", 0);
            catDto = catList.getCats().get((Integer) session.getAttribute("count"));
            session.setAttribute("count1", 1);
            catDto1 = catList.getCats().get((Integer) session.getAttribute("count1"));
        }
        else {
            session.setAttribute("count", count + 2);
            catDto = catList.getCats().get((Integer) session.getAttribute("count"));
            session.setAttribute("count1", count1 + 2);
            catDto1 = catList.getCats().get((Integer) session.getAttribute("count1"));
        }
        model.addAttribute("cat", catDto);
        model.addAttribute("cat1", catDto1);

        return "vote";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

//    @GetMapping(value = "{/logout}")

}
