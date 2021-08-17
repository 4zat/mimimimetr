package com.example.mimimimetr.contollers;

import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.dto.CatsListDTO;
import com.example.mimimimetr.service.CatService;
import com.example.mimimimetr.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpSession;
import java.util.Collections;

public class ControllerUtils {

    public void addCat(CatsListDTO catsListDTO, CatService catService) {
        if (catsListDTO.getCats() == null) {
            catsListDTO.setCats(catService.findAll());
            Collections.shuffle(catsListDTO.getCats());
        }
    }

    public void updateChoice(HttpSession session, UserService userService) {
            session.removeAttribute("cats");
            userService.updateUsersByChoice(SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName());
    }

    public CatDto catAddAndRemove(CatsListDTO catsListDTO, CatDto catDto) {
        if (catsListDTO.getCats().size() > 0) {
            catDto = catsListDTO.getCats().get(0);
            catsListDTO.getCats().remove(0);
        }
        return catDto;
    }
}
