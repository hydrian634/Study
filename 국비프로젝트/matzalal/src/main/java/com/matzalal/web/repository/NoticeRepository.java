package com.matzalal.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.matzalal.web.entity.Notice;

@Mapper
public interface NoticeRepository {

	List<Notice> findAll();
	
}
