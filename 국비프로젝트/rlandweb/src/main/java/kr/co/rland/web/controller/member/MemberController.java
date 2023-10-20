package kr.co.rland.web.controller.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
    @RequestMapping ("index")
    public String index(HttpSession session) {

////        String username = (String)session.getAttribute("username");
//        //Object type으로 형 변환 중 에러 발생가능
//
//
//        //너 인증은 했니? 안했으면 로그인 하렴
//        if(true) //인증한걸 확인을 어떻게 하지? 세션!! 쿠키는 옛날 OS쓰는 사람은 하이재킹당함.
//                //세션에 ID가 들어가있으면 ㅇㅋ
//        return "redirect:/user/login";

//        Object username_ = session.getAttribute("username");
//
//        if(username_ == null)
//            return "redirect:/user/login?returnURL=/member/index";


        return "/member/index";
    }



}
