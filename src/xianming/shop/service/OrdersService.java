package xianming.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xianming.shop.dao.IAddressDao;
import xianming.shop.dao.IOrdersDao;
import xianming.shop.dao.IUserDao;
import xianming.shop.model.Address;
import xianming.shop.model.Orders;
import xianming.shop.model.User;

@Service("ordersService")
public class OrdersService implements IOrdersService {

	private IUserDao userDao;
	private IAddressDao addressDao;
	private IOrdersDao ordersDao;
	
	public IOrdersDao getOrdersDao() {
		return ordersDao;
	}
	@Resource
	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public IAddressDao getAddressDao() {
		return addressDao;
	}
	@Resource
	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	
	@Override
	public void add(Orders orders, int user_id, int address_id) {
		User u = userDao.load(user_id);
		Address address = addressDao.load(address_id);
		orders.setUser(u);
		orders.setAddress(address);
		ordersDao.add(orders);
	}

	@Override
	public void delete(int id) {
		String hql = "delete CartProduct c where c.orders.id=?";
		ordersDao.executeByHql(hql, id);
		ordersDao.delete(id);
	}

	@Override
	public Orders load(int id) {
		return ordersDao.load(id);
	}

	@Override
	public Orders loadByUserId(int user_id) {
		
		return ordersDao.loadByUserId(user_id);
	}

	@Override
	public List<Orders> listByUserId(int user_id) {
		String hql = "select o from Orders o join fetch o.address add join fetch o.user u where u.id=? order by o.buyDate desc";
		return ordersDao.list(hql, user_id);
	}

}
