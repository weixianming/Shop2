package xianming.shop.service;

import java.util.List;

import xianming.shop.model.Orders;
import xianming.shop.model.Pager;

public interface IOrdersService {
	public void add(Orders orders,int user_id,int address_id);
	public void delete(int id);
	public Orders load(int id);
	public Orders loadByUserId(int user_id);
	public List<Orders> listByUserId(int user_id);
	public Pager<Orders> find(int user_id);
}
