package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

@Service
public class MenuServiceImp implements MenuService {

	@Autowired
	private MenuRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

//	@Override
//	public List<Menu> getList() {
//		return repository.findAll();
//	}

//	@Override
//	public List<MenuView> getList(String query) {
//
//		int page=1;
//		int size=9;
//		int offset = size*(page-1);
//		return repository.findViewAll(offset, size, null, query/*page, category, query 3개 인자가 필요함*/);
////	offset, size, null, query
//	}

	@Override
	public Menu getById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<MenuView> getViewList(Integer page, String query, Long categoryId) {
//		int page=1;
		int size=9;
		int offset = size*(page-1);
		List<MenuView> list = repository.findViewAll(offset, size, categoryId, query);

		return list;
	}

	@Override
	public Menu add(Menu menu) {
		repository.save(menu);
		Menu newOne = repository.last();
		return newOne;
	}

	@Override
	public Menu update(Menu menu) {
		repository.update(menu);
		Menu mOne = repository.findById(menu.getId());
		return mOne;
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepository.findCatAll();
	}


}
