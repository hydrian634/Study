package com.matzalal.web.controller.api;

import java.awt.*;
import java.util.List;

import com.matzalal.web.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.matzalal.web.entity.User;
import com.matzalal.web.service.UserService;

@RestController("apiUserController")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;

	@PutMapping
	public String edit(
			@RequestParam String nickname
			) {
		System.out.println(nickname);
		return nickname;
	}

	@GetMapping("{id}")
	public User mypage(@PathVariable Long id) {
		User user = service.getById(id);
		return user;
	}

	@PostMapping
	public User reg(@RequestBody User user) {
		User newOne = service.add(user);
		System.out.println(newOne.getName());

		return newOne;
	}

	@GetMapping
	public User login(@RequestParam("id") String query) {
		User user = service.getByEmail(query);
		return user;
	}

}
