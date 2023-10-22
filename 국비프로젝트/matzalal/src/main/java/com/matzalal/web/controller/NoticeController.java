package com.matzalal.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matzalal.web.entity.Notice;
import com.matzalal.web.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService service;

	@RequestMapping("list")
	public String list(Model model) {
		List<Notice> list = service.getList();
		System.out.println(list);
		model.addAttribute("list", list);

		return "notice/list";

	}

}
