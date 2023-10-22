package com.matzalal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matzalal.web.entity.PostUserLikeView;
import com.matzalal.web.entity.User;
import com.matzalal.web.entity.UserView;
import com.matzalal.web.repository.UserRepository;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
    public List<User> getList() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }
	
    @Override
    public User add(User user) {

        repository.save(user);
        User newUser = repository.last();
        return newUser;
    }
	
    @Override
    public User getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean hasEmail(String email) {
        int cnt = repository.findEmail(email);
        System.out.println("이메일 개수 : " + cnt);

        if(cnt == 1){
            return true;
        } else
            return false;
    };

    @Override
    public User getByEmail(String query) {
        return repository.findByEmail(query);
    }

    @Override
    public boolean hasIdByAlias(String nickname) {
        return repository.hasIdByAlias(nickname);
    }

    @Override
    public UserView getUserViewById(Long id) {
        return repository.findUserViewById(id);
    }
    
// ~~~~~  관리자용 ~~~~~~ //
    
	@Override
	public Integer countUser() {
		int count = repository.count();
		return count;
	}

	@Override
	public void edit(User user) {
		System.out.println("editimp");
		/* return */ repository.modify(user);
	}

	@Override
    public boolean delete(Long id) {
        int rowCount = repository.delete(id);

        if (rowCount == 1) {
            return true;
        }

        return false;
    }
    
    @Override
    public boolean hasName(String name) {
        return repository.hasIdByName(name);
    }

    @Override
    public boolean hasPhone(String phone) {
        return repository.hasIdByPhone(phone);
    }

    @Override
    public User findIdByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<PostUserLikeView> getPostById(long id) {
        return repository.findPostById(id);
    }

}