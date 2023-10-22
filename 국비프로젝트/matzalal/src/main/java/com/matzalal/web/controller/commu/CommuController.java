package com.matzalal.web.controller.commu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matzalal.web.entity.LocCategory;
import com.matzalal.web.entity.Post;
import com.matzalal.web.entity.PostView;
import com.matzalal.web.service.PostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller("CommuController")
@RequestMapping("/commu")
public class CommuController {

	@Autowired
	private PostService postService;
	
	

	@RequestMapping("main")
	public String main(
			Model model, 
			HttpServletRequest request,
			HttpServletResponse response
			){
		
			List<PostView> postList = postService.getPostList();
			List<LocCategory> locCateList = postService.getCategoryList();
	//		List<RankinList> rankingList = service.getRankingList();
			
			System.out.println(postList);
			System.out.println(locCateList);

			model.addAttribute("postList", postList);
			model.addAttribute("locCateList", locCateList);
			
			return "commu/main";
		
			}
	
	
	@GetMapping("post/create")
	
	public String postCreate() {
		System.out.println("get");

		return "commu/post/create";
	}
	
	@PostMapping("post/create") 
	public String postCreate(

			@RequestParam(name="user_id", required =true) Long userId,
			@RequestParam(name="area_id", required =false) Long areaId,
			@RequestParam(required =true) String title,
			@RequestParam(required =true) String content
//			String img1,
//			String img2,
//			String img3
	){
		System.out.println("post");
		Post post = Post.builder()
				.userId(userId)
				.areaId(areaId)
				.title(title)
				.content(content)
//				.img1(img1)
//				.img2(img2)
//				.img3(img3)
				.build();
		System.out.println(post);

		postService.add(post);
		
		return "redirect:/commu/main"; //
	}

			
			
	
	@RequestMapping("post/detail")
	public String postdetail() {
		return "commu/post/detail";
	}
	
	
	
	
}