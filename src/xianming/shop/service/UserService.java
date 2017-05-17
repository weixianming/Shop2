package xianming.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xianming.shop.dao.IUserDao;
import xianming.shop.model.User;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public User loadByUsername(String username) {
		return (User)userDao.queryByHql("select u from User u where u.username=?", username);
	}

	@Override
	public User login(String username, String password) {
		User u = this.loadByUsername(username);
		
		return u;
	}

	@Override
	public List<User> list() {
		return userDao.list("from User");
	}

}
