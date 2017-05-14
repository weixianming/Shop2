package xianming.shop.dao;

import xianming.shop.model.Orders;

public interface IOrdersDao extends IBaseDao<Orders>{
	public Orders loadByUserId(int u_id);
}
