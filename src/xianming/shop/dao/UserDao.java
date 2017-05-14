package xianming.shop.dao;

import org.springframework.stereotype.Repository;

import xianming.shop.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

}
