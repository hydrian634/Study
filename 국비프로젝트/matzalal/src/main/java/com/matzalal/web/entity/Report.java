package com.matzalal.web.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Report {
	
	private Long postReportId;
	private Date createdDate;
	private String content;
	private Boolean processYn;
	private Date processDate;
	private Long userId;
	private Long postId;
	private Long adminId;
	private Long reportReasonId;
	
//  다른 테이블	
//	private Long commentsReportId;
//	private Long reportUserId;
//	private Long reportedUserId;
//	
//	
//	private Long userReportId;
//	
//	private String category;
}
