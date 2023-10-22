package com.matzalal.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.matzalal.web.entity.PostUserLikeView;
import com.matzalal.web.entity.User;
import com.matzalal.web.entity.UserView;

@Mapper
public interface UserRepository {
    List<User> findAll();

    int save(User user);

    User findById(Long id);

    User last();

    int findEmail(String email);

    User findByEmail(String email);

    boolean hasIdByAlias(String nickname);

    UserView findUserViewById(Long id);
	
	
// ~!~~~~~~관리자용 ~~~~~//
    
	Integer count();

	void modify(User user);

    int delete(Long id);
    
    boolean hasIdByName(String name);

    boolean hasIdByPhone(String phone);

    User findByName(String name);

    User modifyNickName(String nickname);

    List<PostUserLikeView> findPostById(long id);
}
