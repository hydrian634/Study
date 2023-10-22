package com.matzalal.web.controller;

import com.matzalal.web.entity.RecomView;
import com.matzalal.web.entity.Review;
import com.matzalal.web.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private HomeService service;

	@RequestMapping("index")
	public String index(Model model) {


		List<RecomView> recomViewList = service.getRecomViewList();
		List<Review> reviewList = service.getReviewList();

		System.out.println(recomViewList);
		System.out.println(reviewList);

		model.addAttribute("recom", recomViewList);
		model.addAttribute("review", reviewList);

		return "index";
	}
}
