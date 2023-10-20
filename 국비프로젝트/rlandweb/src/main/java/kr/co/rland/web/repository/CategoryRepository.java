package kr.co.rland.web.repository;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    List<Category> findCatAll();

}
