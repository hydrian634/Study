package com.matzalal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matzalal.web.entity.Faq;
import com.matzalal.web.repository.FaqRepository;

@Service
public class FaqServiceImp implements FaqService {

	@Autowired
	private FaqRepository repository;
	
	@Override
	public List<Faq> getList() {

		return repository.findAll();
	}
}
