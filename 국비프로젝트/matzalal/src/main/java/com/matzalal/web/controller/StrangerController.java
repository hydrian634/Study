package com.matzalal.web.controller;

import com.matzalal.web.entity.User;
import com.matzalal.web.service.StrangerService;
import com.matzalal.web.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("StrangerController")
@RequestMapping("stranger")
public class StrangerController {

    @Autowired
    private StrangerService strangerService;
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String login() {
        return "stranger/login";
    }

    @PostMapping("login")
    public String login(
            String email,
            String pwd,
            @RequestParam("return-url") String returnURL,
            HttpSession session
    ) {


        // 로그인 유효성 검사
        if (strangerService.isValid(email, pwd)) {
            User user = userService.getByEmail(email);
            session.setAttribute("user", user);


            System.out.println("returnURL :::::" + returnURL);

            // 리턴URL 유무 확인
            if (returnURL != null && returnURL != ""){
                return "redirect:" + returnURL;
            }
            return "redirect:/user/mypage";
        }

        // 로그인 유효성 검사 실패시 페이지 리턴
        return "redirect:login?error";

    }

}
