package com.matzalal.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.matzalal.web.entity.Post;
import com.matzalal.web.entity.PostView;

@Mapper
public interface PostRepository {
	

	List<PostView> findPostAll();

	void save(Post post);

	Post last();
	
}
