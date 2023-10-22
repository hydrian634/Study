package com.matzalal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matzalal.web.entity.Report;
import com.matzalal.web.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService service;

	@RequestMapping("post")
	public String post(Model model) {
//		model.addAttribute("post", post);  
		return "report/post";
	}
	
	@RequestMapping("comments")
	public String comments(Model model) {
		return "report/comments";
	}	
	
	@RequestMapping("user")
	public String user(Model model) {
		return "report/user";
	}		
	
	
	
	@PostMapping("reg")
	public String reg(
			String textarea,
			Long userId,
			Long postId,
			Long reportReasonId,
			Long adminId
			) {
		
		System.out.println("텍스트에어리아:" + textarea);
		Report report = Report.builder()
				.content(textarea)
				.userId(3L)
				.postId(12L)
				.reportReasonId(1L)
				.adminId(3L)
				.build();
		
		System.out.println("report:" + report);

		service.add(report);
		
		return "redirect:post";
	}
	
	
	
	
	

}
