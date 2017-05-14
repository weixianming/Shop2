package xianming.shop.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T>{

	private Class<T> clz;
	
	@Resource(name="sessionFactory")
	private void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(int id) {
		this.getHibernateTemplate().delete(this.load(id));
	}

	@Override
	public T load(int id) {
		return this.getHibernateTemplate().get(getClz(), id);
	}


	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}
	
	private Query setParameter(String hql,Object[] args){
		Query q = this.getSession().createQuery(hql);
		if(args!=null){
			for(int i=0;i<args.length;i++){
				q.setParameter(i, args[i]);
			}
		}
		return q;
	}

	@Override
	public List<T> list(String hql, Object[] args) {
		Query q = this.setParameter(hql, args);
		return q.list();
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[]{arg});
	}

	@Override
	public List<T> list(String hql) {
		return this.list(hql, null);
	}

	@Override
	public Object queryByHql(String hql, Object[] args) {
		Query q = this.setParameter(hql, args);
		return q.uniqueResult();
	}

	@Override
	public Object queryByHql(String hql, Object arg) {
		return this.queryByHql(hql,new Object[]{arg});
	}

	@Override
	public Object queryByHql(String hql) {
		return this.queryByHql(hql, null);
	}

	@Override
	public void executeByHql(String hql, Object[] args) {
		Query q = setParameter(hql, args);
		q.executeUpdate();
	}

	@Override
	public void executeByHql(String hql, Object arg) {
		this.executeByHql(hql, new Object[]{arg});
	}

	@Override
	public void executeByHql(String hql) {
		this.executeByHql(hql, null);
	}

}
