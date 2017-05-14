package xianming.shop.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import xianming.shop.model.Orders;

@Repository("ordersDao")
public class OrdersDao extends BaseDao<Orders> implements IOrdersDao {

	@Override
	public Orders loadByUserId(int u_id) {
		String hql = "select o from Orders o where o.user.id=?";
		Query q = this.getSession().createQuery(hql);
		return (Orders)q.uniqueResult();
	}

}
