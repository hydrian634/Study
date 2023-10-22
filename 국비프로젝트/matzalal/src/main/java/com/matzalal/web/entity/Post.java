package com.matzalal.web.entity;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;


@Data
@Builder
@AllArgsConstructor
public class Post {
	
	private Long id;
	private Long userId;
	private Long areaId;
	private String title;
	private String content;
	private String img1;
	private String img2;
	private String img3;
	private Integer hit;
	private Date createdDate;
	
}
