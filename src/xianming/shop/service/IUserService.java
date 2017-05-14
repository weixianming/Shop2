package xianming.shop.service;

import java.util.List;

import xianming.shop.model.User;

public interface IUserService {
	public void add(User user);
	
	public void delete(int id);
	
	public void update(User user);
	
	public User load(int id);
	
	public User loadByUsername(String username);
	
	public User login(String username,String password);
	
	public List<User> list();
}
