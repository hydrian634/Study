package com.matzalal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matzalal.web.entity.Notice;
import com.matzalal.web.repository.FaqRepository;
import com.matzalal.web.repository.NoticeRepository;

@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	private NoticeRepository repository;
	
	@Override
	public List<Notice> getList() {

		return repository.findAll();
	}

}
