package kr.co.rland.web.controller.user;

import jakarta.servlet.http.HttpSession;
import kr.co.rland.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

@Autowired
private MemberService service;

    @GetMapping("login")
    public String login(){

        return "user/login";
    }

    @PostMapping("login")
    public String login(String username,
                        String password,
                        @RequestParam("return-url") String returnURL,
                        HttpSession session){
        System.out.println(service.isValid(username, password));
        if(service.isValid(username, password)) {
            session.setAttribute("username", username);

            if(returnURL != null && !returnURL.equals(""))
                return "redirect:" + returnURL;

            return "redirect:/index";
        }

        //2개 경로 :
        //1. 가다가 걸려서 왔으면 인증하고 거기로 다시 returnURL
        //2. 걸릿 것이 없이 자발적으로 여기를 요청한거라면 member/index
        return "redirect:./login?error";
    }
}
