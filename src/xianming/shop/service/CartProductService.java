package xianming.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xianming.shop.dao.CartProductDao;
import xianming.shop.dao.ICartProductDao;
import xianming.shop.dao.IOrdersDao;
import xianming.shop.dao.IProductDao;
import xianming.shop.model.CartProduct;
import xianming.shop.model.Orders;
import xianming.shop.model.Product;

@Service("cateProductService")
public class CartProductService implements ICartProductService {

	private IProductDao productDao;
	private IOrdersDao ordersDao;
	private ICartProductDao cartProductDao;
	
	public IProductDao getProductDao() {
		return productDao;
	}
	@Resource
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}
	public IOrdersDao getOrdersDao() {
		return ordersDao;
	}
	@Resource
	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	public ICartProductDao getCateProductDao() {
		return cartProductDao;
	}
	
	@Resource
	public void setCateProductDao(ICartProductDao cartProductDao) {
		this.cartProductDao = cartProductDao;
	}

	@Override
	public void add(CartProduct cartProduct) {
		cartProductDao.add(cartProduct);
	}

	@Override
	public void delete(int id) {
		cartProductDao.delete(id);
	}

	@Override
	public void update(CartProduct cartProduct) {
		cartProductDao.update(cartProduct);
	}

	@Override
	public List<CartProduct> listByOrderId(int o_id) {
		String hql = "SELECT cp FROM CartProduct cp WHERE cp.orders.id=?";
		return cartProductDao.list(hql, o_id);
	}
	
	

}
