package com.matzalal.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matzalal.web.entity.Report;
import com.matzalal.web.repository.ReportRepository;

@Service
public class ReportServiceImp implements ReportService {

	@Autowired
	private ReportRepository repository;
	
	@Override
	public Report add(Report report) {
        repository.save(report);
        Report addReport = repository.last();
        return addReport;
	}
}
