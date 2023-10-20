package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.CategoryRepository;

public interface MenuService {
//	List<Menu> getList();
	List<MenuView> getViewList(Integer page, String query, Long categoryId);
//	List<MenuView> getViewList();


	Menu getById(long id);

    Menu add(Menu menu);

	Menu update(Menu menu);

	List<Category> getCategoryList();

//    List<MenuView> getCategoryList();
}
