package xianming.shop.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xianming.shop.model.Address;
import xianming.shop.service.IAddressService;
import xianming.shop.service.IUserService;
import xianming.shop.service.OrdersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestAddress {

	private IAddressService addressService;
	
	public IAddressService getAddressService() {
		return addressService;
	}
	
	@Resource
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}
	
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	@Test
	public void testadd() {
		Address address = new Address();
		address.setName("南海横路2号");
		address.setPhone("1306464482");
		address.setPostcode("515001");
		address.setUser(userService.load(1));
		addressService.add(address);
	}
	
	@Test
	public void testList(){
		List<Address> adds = addressService.list(1);
		for(Address add:adds){
			System.out.println(add.getName());
		}
		
	}

}
