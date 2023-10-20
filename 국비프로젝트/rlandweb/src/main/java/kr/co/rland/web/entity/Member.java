package kr.co.rland.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Member {
    private String id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Date regDate;

}
