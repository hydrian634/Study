package com.matzalal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matzalal.web.entity.LocCategory;
import com.matzalal.web.entity.Post;
import com.matzalal.web.entity.PostView;
import com.matzalal.web.repository.LocCateRepository;
import com.matzalal.web.repository.PostRepository;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LocCateRepository locCateRepository;
	

	@Override
	public Post add(Post post) {

		postRepository.save(post);

		Post newPost = postRepository.last();

		return newPost;
	}


	@Override
	public List<PostView> getPostList() {
		return postRepository.findPostAll();
	}


	@Override
	public List<LocCategory> getCategoryList() {
		return locCateRepository.findAll();
	}


	
}
