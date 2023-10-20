package kr.co.rland.web.entity;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Menu {
		private Long id;
	   private String korName;
	   private String engName;
	   private Integer price;
	   private String img;
	   private String description;
	   private Boolean isSmall;
	   private Date regDate;
	   private Integer hit;
	   private Long memberId;
}
