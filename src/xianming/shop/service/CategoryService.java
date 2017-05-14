package xianming.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xianming.shop.dao.ICategoryDao;
import xianming.shop.model.Category;

@Service("categoryService")
public class CategoryService implements ICategoryService {
	
	private ICategoryDao categoryDao;
	
	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	@Resource
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public void add(Category category) {
		categoryDao.add(category);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public Category load(int id) {
		return categoryDao.load(id);
	}

	@Override
	public List<Category> list() {
		return categoryDao.list("select c from Category c");
	}


}
