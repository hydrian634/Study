package com.matzalal.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.matzalal.web.entity.Report;

@Mapper
public interface ReportRepository {

	List<Report> findAll();

	void save(Report report);

	Report last();


}
