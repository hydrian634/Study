package com.matzalal.web.controller;

import com.matzalal.web.entity.Post;
import com.matzalal.web.entity.PostUserLikeView;
import com.matzalal.web.entity.User;
import com.matzalal.web.entity.UserView;
import com.matzalal.web.service.PostService;
import com.matzalal.web.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller("UserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("reg")
    public String reg(Model model) {

        List<User> list = userService.getList();

        model.addAttribute("list", list);

        return "user/reg_user";
    }

    @PostMapping("reg")
    public String reg(
            String email,
            String pwd,
            String name,
            String phone,
            String alias,
            @RequestParam(name = "location-id", defaultValue = "0") int locationId

    ) {
        User user = User.builder()
                .email(email)
                .pwd(pwd)
                .name(name)
                .phone(phone)
                .alias(alias)
                .locationId(locationId)
                .build();

        userService.add(user);

        System.out.println("비밀번호:" + pwd);
        System.out.println("이메일:" + email);
        System.out.println("이름:" + name);
        System.out.println("휴대폰번호" + phone);
        System.out.println("닉네임" + alias);
        System.out.println("locationId:" + locationId);

        return "redirect:login";
    }


    @RequestMapping("reg/agree")
    public String regAgree() {
        return "user/reg_agree";
    }


    @GetMapping("mypage")
    public String mypage(Model model,
                         HttpSession session) {
        System.out.println("mypage 동작");
        UserView userView = userService.getUserViewById(3L);
        System.out.println("게시물수 : " + userView.getPostCount());
        model.addAttribute("userView", userView);

        System.out.println(userView);

        Object user = session.getAttribute("user");
        System.out.println("useruser : "+ user);


        if (user == null)
            return "redirect:../stranger/login?returnURL=/user/mypage";

        Object email = session.getAttribute("email");

        if (email == null)
            return "redirect:../stranger/login?returnURL=/user/mypage";

        return "user/mypage";
    }

    // ================================아이디 찾기=============================

    @RequestMapping("findid")
    public String findid() {

        return "user/findid";
    }

    // ================================비밀번호 찾기=============================
    @RequestMapping("findpw")
    public String findpw() {
        return "user/findpw";
    }

    // ================================회원정보 변경=============================
    @RequestMapping("edit")
    public String edit(HttpSession session) {
        Object user = session.getAttribute("user");
        System.out.println("edit=> Session : "+ user);

        if (user == null)
            return "redirect:../stranger/login?returnURL=/user/edit";

        return "user/edit_user";
    }

    // ================================등급표=============================
    @RequestMapping("grade")
    public String grade() {
        return "user/grade";
    }

    // ================================찜목록 =============================
    @RequestMapping("myfav")
    public String fav() {
        return "user/fav";
    }

    // ================================작성한 글 =============================
    @RequestMapping("mypost")
    public String post(Model model) {
        UserView userView = userService.getUserViewById(3L);
        model.addAttribute("userView", userView);

        List<PostUserLikeView> myPostList = userService.getPostById(3L);
        System.out.println(myPostList);

        model.addAttribute("list", myPostList);

        return "user/mypost";
    }

    // ================================작성한 후기 =============================
    @RequestMapping("mycomment")
    public String comment() {
        return "user/mycomment";
    }

    // ================================회원탈퇴 =============================
    @RequestMapping("delete")
    public String delete(Model model) {
        User user = userService.getById(3L);
        model.addAttribute("user", user);
        return "user/user_delete";
    }
}