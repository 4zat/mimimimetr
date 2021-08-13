package com.example.mimimimetr.contollers;


import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.dto.CatsListDTO;
import com.example.mimimimetr.repo.CatRepository;
import com.example.mimimimetr.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {

    private final CatService catService;
    private final CatRepository catRepository;

    public MainController(CatService catService, CatRepository catRepository) {
        this.catService = catService;
        this.catRepository = catRepository;
    }

    @GetMapping("/top")
    public String topCats(Model model) {
        List<CatDto> list = catService.findAll();

        Comparator<CatDto> comp = Comparator.comparing(CatDto::getCatPoint);
        list.sort(comp.reversed());

        model.addAttribute("catList", list);

        return "top";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/vote")
    public String vote(Model model, HttpSession session,
                       @RequestParam(name = "id", required = false) String id) {



        CatsListDTO catList = new CatsListDTO();

        CatDto catDto = new CatDto();
        CatDto catDto1 = new CatDto();

        if (catList.getCats() == null) {
            catList.setCats(catService.findAll());
            Collections.shuffle(catList.getCats());
        }

        if (session.getAttribute("cats") instanceof CatsListDTO)
            if (session.getAttribute("cats") != null)
                catList = (CatsListDTO) session.getAttribute("cats");


        if (catList.getCats().size() == 0) {
            session.removeAttribute("cats");
            catList.setCats(catService.findAll());
            Collections.shuffle(catList.getCats());
            return "redirect:top";
        }

        if (catList.getCats().size() > 0) {
            catDto = catList.getCats().get(0);
            System.out.println(id);
            catList.getCats().remove(0);
        }
        if (catList.getCats().size() > 0) {
            catDto1 = catList.getCats().get(0);
            catList.getCats().remove(0);
        }

        session.setAttribute("cats", catList);
        model.addAttribute("cat", catDto);
        model.addAttribute("cat1", catDto1);

        return "vote";
    }

    @PostMapping("/vote")
    public String test(@RequestParam(name = "id", required = false) int id) {

        List<CatDto> catDtoList = catService.findAll();

        catRepository.pointCounter(id, catDtoList.get(id - 1).getCatPoint() + 1);

        return "redirect:vote";
    }


//    @GetMapping(value = "{/logout}")


}
