package com.matzalal.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matzalal.web.entity.Report;
import com.matzalal.web.service.ReportService;

@RestController("apiReportController")
@RequestMapping("/api/reports")
public class ReportController {
		
		@Autowired
		private ReportService service;
		

		
}