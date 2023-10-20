package kr.co.rland.web.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import kr.co.rland.web.service.MenuService;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService service;

//	@Autowired
//	private CategoryService categoryService;

//	@ResponseBody	
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {

//		Cookie ck = new Cookie("test","hello");
//		response.addCookie(ck);
//		if(request.getCookies().length < 1 || request.getCookies() == null)
//			response.addCookie(ck);

		Cookie ck = new Cookie("test","hello");
//		ck.setPath("/");
		if(request.getCookies() == null || request.getCookies().length < 1)
			response.addCookie(ck);

//		HttpSession session = request.getSession();

//		List<Menu> list = service.getList();
		List<MenuView> list = service.getViewList(1, null, null);
		List<Category> categoryList = service.getCategoryList() ;

		System.out.println(list);
		System.out.println(categoryList);

		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);

//		System.out.println(session.getAttribute("test"));
		//세션이 달라 값을 다르게 보는 것? 아니면 값이 달라 세션이 다른 것?
		//아마 전자일거같은데?

		return "menu/list"; // template에서 list.html을 찾음.
	}

	@PostMapping("reg")
	public String reg(
			@RequestParam("kor-name") String korName,
			@RequestParam(defaultValue = "0") int price,
			String description,
			@RequestParam("is-small") boolean isSmall,
			String img
	) {

		System.out.println(price);
		System.out.println(isSmall);
		System.out.println(img);

		return "redirect:list";
	}

//	@ResponseBody
	@RequestMapping("detail")
	public String detail(Long id, Model model,/* HttpServletRequest request*/
	@CookieValue String test) {
	//CookieValue는 쿠키 값이기 때문에 무조건 변수 이름으로 쿠키 이름(Cookie name)이 와야 한다.
		System.out.println(test);

		Menu menu = service.getById(id);

		model.addAttribute("menu", menu);

//		Cookie[] cookies = request.getCookies();
//		for(Cookie c : cookies)
//			if(c.getName().equals("test"))
//				//==if(c.getName().contains("test"))
//				System.out.println(c.getValue());


		return "menu/detail"; // template에서 detail.html을 찾음.
	}
}
