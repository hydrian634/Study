package com.matzalal.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Review {
            private Integer reviewId;
    private Integer userId;
    private Integer restId;
    private Long rating;
    private String content;
    private String bannerImg;
    private Date created_date;
    private String restName;
    private String alias;
}
