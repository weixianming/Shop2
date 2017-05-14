package xianming.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xianming.shop.dao.ICategoryDao;
import xianming.shop.dao.IProductDao;
import xianming.shop.model.Category;
import xianming.shop.model.Product;

@Service("productService")
public class ProductService implements IProductService {

	private ICategoryDao categoryDao;
	private IProductDao productDao;
	
	public IProductDao getProductDao() {
		return productDao;
	}
	
	@Resource
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}
	
	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	@Resource
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public void add(Product product, int c_id) {
		Category category = categoryDao.load(c_id);
		product.setCategory(category);
		productDao.add(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public Product load(int id) {
		return productDao.load(id);
	}

	@Override
	public List<Product> listByCid(int c_id) {
		String hql = "select p from Product p where p.category.id=?";
		return productDao.list(hql, c_id);
	}

	@Override
	public List<Product> list() {
		String hql = "select p from Product p join fetch p.category";
		return productDao.list(hql);
	}

}
