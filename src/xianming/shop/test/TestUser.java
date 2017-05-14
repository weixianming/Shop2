package xianming.shop.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xianming.shop.model.CartProduct;
import xianming.shop.model.User;
import xianming.shop.service.ICartProductService;
import xianming.shop.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUser {

	private IUserService userService;
	private ICartProductService cartProductService;
	
	public IUserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public ICartProductService getCartProductService() {
		return cartProductService;
	}
	
	@Resource
	public void setCartProductService(ICartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}
	
	@Test
	public void add() {
		User u = new User();
		u.setUsername("laobai");
		u.setType(0);
		u.setPassword("123");
		u.setNickname("老白");
		userService.add(u);
	}
	
	@Test
	public void list(){
		List<User> users = userService.list();
		for(User u:users){
			System.out.println(u.getNickname());
			System.out.println(u.getUsername());
		}
	}
	
	@Test
	public void CartProductlist(){
		List<CartProduct> list = cartProductService.listByOrderId(2);
		for(CartProduct c:list){
			System.out.println(c.getNumber());
		}
	}
	
}
