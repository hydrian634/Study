package com.matzalal.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matzalal.web.entity.Faq;
import com.matzalal.web.service.FaqService;

@Controller
@RequestMapping("/faq")
public class FaqController {

	@Autowired
	private FaqService service;

	@RequestMapping("list")
	public String list(Model model) {
		List<Faq> list = service.getList();
		System.out.println(list);
		model.addAttribute("list", list);

		return "faq/list";

	}

}
