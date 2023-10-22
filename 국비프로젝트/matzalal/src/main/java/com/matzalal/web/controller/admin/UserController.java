package com.matzalal.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matzalal.web.entity.User;
import com.matzalal.web.service.UserService;

@Controller("AdminUserController")
@RequestMapping("/admin/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//회원 목록 페이지 
		@RequestMapping("list")
		public String user(Model model) {
			List<User> list = service.getList();
			int count = service.countUser();
			
			System.out.println(list);
			
			System.out.println("회원은 총:"+count);
			model.addAttribute("list", list);
			model.addAttribute("count", count);
			
			return "admin/user/list";
		}

	
	
	// 수정 페이지
	@GetMapping("edit")
	public String getEdit(Long id, Model model) {
		System.out.println(id);
//		paramId = 3L;
//		id=3L;
		
		User userDtl = service.getById(id);
		System.out.println(userDtl);
		System.out.println("------");
		
		model.addAttribute("userDtl", userDtl);
		return "admin/user/edit";
	}
	
	
	
//	// 상세조회 페이지
//	@GetMapping("detail")
//	public String reg() {
//		return "/admin/user/detail";
//	}

//	@PostMapping("detail")
//	public String reg(
////			@RequestParam(name="userImg") String profileImg,
//			@RequestParam(name="grade", required=true) Long gradeId,
//			@RequestParam(name="alias", required=true) String alias,
//			@RequestParam(name="email", required=true) String email,
//			@RequestParam(name="pwd", required=true) String pwd,
//			@RequestParam(name="name", required=true) String name,
//			@RequestParam(name="phone", required=true) String phone,
//			@RequestParam(name="status") Long statusId
//			) {
//		
//			User user = User.builder()
//							.profileImg("user.png")
//							.gradeId(gradeId)
//							.alias(alias)
//							.email(email)
//							.pwd(pwd)
//							.name(name)
//							.phone(phone)
//							.statusId(statusId)
//							.build();
//			System.out.println(user);
//			service.add(user);
//					
//		return "redirect:list";
//	}
	
}