package xianming.shop.dao;

import org.springframework.stereotype.Repository;

import xianming.shop.model.Category;

@Repository("categoryDao")
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {

}
