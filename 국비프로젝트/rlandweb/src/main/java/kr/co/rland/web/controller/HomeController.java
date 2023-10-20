package kr.co.rland.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
	
//	@ResponseBody
	@RequestMapping("index")
	public String index(@RequestParam(defaultValue = "hi") String test/*,
						HttpServletRequest request*/) {

//		HttpSession session = request.getSession();
//		session.setAttribute("test", test); //세션을 얻음.

		return "index";
	}


}
