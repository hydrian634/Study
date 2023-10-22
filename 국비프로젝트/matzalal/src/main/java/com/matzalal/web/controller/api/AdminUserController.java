package com.matzalal.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matzalal.web.entity.User;
import com.matzalal.web.service.UserService;

@RestController("adminApiUserController")
@RequestMapping("admin/api/users")
public class AdminUserController {

	@Autowired
	private UserService service;
	
	
	
// ~~~~~~~~~  관리자용  ~~~~~~~~
	// @ResponseBody
	@GetMapping
	public List<User> list() {
		
		List<User> list = service.getList();
		System.out.println("dd");
		return list;
	}

	@GetMapping("{id}")
	public User detail(@PathVariable Long id) {
		System.out.println("cont1");
		User user = service.getById(id);
		System.out.println(user);
		System.out.println("~~~~");

		return user;
	}

	@PutMapping("{id}")
	public void update(
			@RequestBody User user) {
		System.out.println(user);
		service.edit(user);
		

//		return updateUser;
	}
	
	@DeleteMapping("{id}")
	public Boolean delete(Long id) {
		boolean result = service.delete(id);
		
		return result;
	}
	
	
}
