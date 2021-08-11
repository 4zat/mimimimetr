package com.example.mimimimetr.contollers;


import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.service.CatService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private final CatService catService;
    private final CatPair catPair;

    public MainController(CatService catService, CatPair catPair) {
        this.catService = catService;
        this.catPair = catPair;
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
        List<CatDto> catList = catService.findAll();
        Collections.shuffle(catList);


        Integer count = (Integer) session.getAttribute("count");
        Integer count1 = (Integer) session.getAttribute("count1");

        CatDto catDto;
        CatDto catDto1;

        if (count == null || count1 == null) {
            count = 0;
            count1 = 1;
            session.setAttribute("count", 0);
            catDto = catList.get((Integer) session.getAttribute("count"));
            session.setAttribute("count1", 1);
            catDto1 = catList.get((Integer) session.getAttribute("count1"));
        } else {
            session.setAttribute("count", count + 2);
            catDto = catList.get((Integer) session.getAttribute("count"));
            session.setAttribute("count1", count1 + 2);
            catDto1 = catList.get((Integer) session.getAttribute("count1"));
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
