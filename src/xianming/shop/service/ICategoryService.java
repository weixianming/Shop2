package xianming.shop.service;

import java.util.List;

import xianming.shop.model.Category;

public interface ICategoryService{
	public void add(Category category);
	public void delete(int id);
	public void update(Category category);
	public Category load(int id);
	public List<Category> list();
}
