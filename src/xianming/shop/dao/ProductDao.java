package xianming.shop.dao;

import org.springframework.stereotype.Repository;

import xianming.shop.model.Product;

@Repository("productDao")
public class ProductDao extends BaseDao<Product> implements IProductDao {

}
