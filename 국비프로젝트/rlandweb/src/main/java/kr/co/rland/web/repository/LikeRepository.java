package kr.co.rland.web.repository;

import kr.co.rland.web.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
public interface LikeRepository {
    Like last();

    int delete(Long menuId, Long memberId);

    void save(Like like);
}
