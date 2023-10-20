package kr.co.rland.web.entity;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Category {
    private Long id;
    private String name;
}
