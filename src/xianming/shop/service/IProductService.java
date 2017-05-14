package xianming.shop.service;

import java.util.List;

import xianming.shop.model.Product;

public interface IProductService {
	public void add(Product product,int c_id);
	public void update(Product product);
	public void delete(int id);
	public Product load(int id);
	public List<Product> listByCid(int c_id);
	public List<Product> list();
}
