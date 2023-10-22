package com.matzalal.web.service;

import java.util.List;

import com.matzalal.web.entity.LocCategory;
import com.matzalal.web.entity.Post;
import com.matzalal.web.entity.PostView;

public interface PostService {

	
	Post add(Post post);

	List<PostView> getPostList();

	List<LocCategory> getCategoryList();

	
	
}
