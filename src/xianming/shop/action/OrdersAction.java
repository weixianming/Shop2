package xianming.shop.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xianming.shop.exception.ShopException;
import xianming.shop.model.Address;
import xianming.shop.model.CartProduct;
import xianming.shop.model.Orders;
import xianming.shop.model.Product;
import xianming.shop.model.ShopCart;
import xianming.shop.model.User;
import xianming.shop.service.IAddressService;
import xianming.shop.service.ICartProductService;
import xianming.shop.service.IOrdersService;
import xianming.shop.service.IProductService;

@Controller("ordersAction")
@RequestMapping("/orders")
public class OrdersAction {
	
	private IAddressService addressService;
	private IOrdersService ordersService;
	private ICartProductService cartProductService;
	private IProductService productService;

	public IProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public ICartProductService getCartProductService() {
		return cartProductService;
	}
	@Resource
	public void setCartProductService(ICartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}
	public IAddressService getAddressService() {
		return addressService;
	}

	@Resource
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}
	
	public IOrdersService getOrdersService() {
		return ordersService;
	}
	@Resource
	public void setOrdersService(IOrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute Orders orders,Model model,HttpSession session){
		double totalPrice = 0;
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			throw new ShopException("请先登录");
		}
		ShopCart shopCart = (ShopCart)session.getAttribute("ShopCart"); 
		List<CartProduct> cartProducts = shopCart.getList();
		for(CartProduct cp:cartProducts){
			totalPrice +=cp.getPrice();
		}
		model.addAttribute("cartProducts", cartProducts);
		List<Address> addresses = addressService.list(loginUser.getId());
		model.addAttribute("addresses", addresses);
		model.addAttribute("totalPrice", totalPrice);
		return "orders/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Orders orders,int a_id,HttpSession session){
		Address address = addressService.load(a_id);
		User u = (User)session.getAttribute("loginUser");
		orders.setBuyDate(new Date());
		ordersService.add(orders, u.getId(), address.getId());
		ShopCart shopCart = (ShopCart)session.getAttribute("ShopCart");
		List<CartProduct> cartProducts = shopCart.getList();
		for(CartProduct cp:cartProducts){
			cp.setOrders(orders);
			cartProductService.add(cp);
			int number = cp.getNumber();
			Product p = productService.load(cp.getProduct().getId());
			p.setStock(p.getStock()-number);
			productService.update(p);
		}
		session.removeAttribute("ShopCart");
		return "redirect:/orders/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model,HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			throw new ShopException("请先登录");
		}
		List<Orders> orderes = ordersService.listByUserId(loginUser.getId());
		model.addAttribute("orederes",orderes);
		return "orders/list";
	}
	
	@RequestMapping(value="/{o_id}/show",method=RequestMethod.GET)
	public String show(@PathVariable int o_id,Model model){
		List<CartProduct> cartProducts = cartProductService.listByOrderId(o_id);
		model.addAttribute("cartProducts", cartProducts);
		
		return "orders/show";
	}
}
