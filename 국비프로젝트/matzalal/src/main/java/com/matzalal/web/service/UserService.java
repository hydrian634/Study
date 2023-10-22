package com.matzalal.web.service;

import com.matzalal.web.entity.PostUserLikeView;
import com.matzalal.web.entity.User;
import com.matzalal.web.entity.UserView;

import java.util.List;


public interface UserService {
    List<User> getList();

    User add(User user);

    User getById(Long id); //	User getById(Long userId);

    boolean hasEmail(String email);

    User getByEmail(String query);

    boolean hasIdByAlias(String nickname);

    UserView getUserViewById(Long id);
	

	/*   관리자 페이지      */
	Integer countUser();

	void edit(User user);

    boolean delete(Long id);
    
    boolean hasName(String name);

    boolean hasPhone(String phone);

    User findIdByName(String name);

    List<PostUserLikeView> getPostById(long id);
	
	


}