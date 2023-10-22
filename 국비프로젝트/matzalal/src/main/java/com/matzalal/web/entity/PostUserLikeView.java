package com.matzalal.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class PostUserLikeView {
    private Long id;
    private String alias;
    private Long userId;
    private Long areaId;
    private String title;
    private String content;
    private String img1;
    private String img2;
    private String img3;
    private Integer hit;
    private Date createdDate;
    private Long postLikeCount;
    private Long gradeId;
    private String profileImg;
}
