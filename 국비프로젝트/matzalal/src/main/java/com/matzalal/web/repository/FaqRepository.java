package com.matzalal.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.matzalal.web.entity.Faq;

@Mapper
public interface FaqRepository {

	List<Faq> findAll();
}
