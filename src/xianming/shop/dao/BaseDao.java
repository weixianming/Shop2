package xianming.shop.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xianming.shop.model.SystemContext;
import xianming.shop.model.Pager;


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

	@Override
	public Pager<T> find(String hql, Object[] args) {
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		if(pageSize<=0) pageSize = 10;
		if(pageOffset<0) pageOffset = 0; 
		Query q = setParameter(hql, args);
		q.setFirstResult(pageOffset).setMaxResults(pageSize);
		String cHql = getCountHql(hql);
		Query cq = setParameter(cHql, args);
		Pager<T> pager = new Pager<T>();
		pager.setPageOffset(pageOffset);
		pager.setPageSize(pageSize);
		List<T> datas = q.list();
		pager.setDatas(datas);
		long totalRecord = (long)cq.uniqueResult();
		pager.setTotalRecord(totalRecord);
		return pager;
	}
	
	private String getCountHql(String hql){
		String s = hql.substring(0,hql.indexOf("from"));
		if(s==null||s.trim().equals("")){
			hql = "select count(*)" +hql;
		} else{
			hql = hql.replace(s, "select count(*)");
		}
		hql = hql.replace("fetch", "");
		return hql;
	}

	@Override
	public Pager<T> find(String hql, Object obj) {
		return this.find(hql, new Object[]{obj});
	}

	@Override
	public Pager<T> find(String hql) {
		return this.find(hql,null);
	}

}
