package xianming.shop.dao;

import java.util.List;

public interface IBaseDao<T> {
	public void add(T t);
	public void delete(int id);
	public T load(int id);
	public void update(T t);
	public List<T> list(String hql,Object[] args);
	public List<T> list(String hql,Object arg);
	public List<T> list(String hql);
	
	/**
	 * 通过hql获取一个对象
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryByHql(String hql,Object[] args);
	public Object queryByHql(String hql,Object arg);
	public Object queryByHql(String hql);
	
	/**
	 * 调用hql更新一组对象
	 * @param hql
	 * @param args
	 */
	public void executeByHql(String hql,Object[] args);
	public void executeByHql(String hql,Object arg);
	public void executeByHql(String hql);
}
