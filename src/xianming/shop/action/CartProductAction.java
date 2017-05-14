package xianming.shop.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xianming.shop.model.Product;
import xianming.shop.model.ShopCart;
import xianming.shop.service.ICartProductService;
import xianming.shop.service.IProductService;

@Controller("cartProductAction")
@RequestMapping("/cartProduct")
public class CartProductAction {
	
	private ICartProductService cartProductService;
	private IProductService productService;
	
	public ICartProductService getCartProductService() {
		return cartProductService;
	}
	
	@Resource
	public void setCartProductService(ICartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}
	
	public IProductService getProductService() {
		return productService;
	}
	
	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(int number,int pid,HttpSession session){
		ShopCart shopCart = (ShopCart)session.getAttribute("ShopCart");
		if(shopCart==null){
			shopCart = new ShopCart();
		}
		Product product = productService.load(pid);
		shopCart.add(product, number);
		session.setAttribute("ShopCart", shopCart);
		return "redirect:/cartProduct/shopCart";
	}
	
	@RequestMapping(value="/shopCart",method=RequestMethod.GET)
	public String shopCart(Model model,HttpSession session){
		ShopCart shopCart = (ShopCart)session.getAttribute("ShopCart");
		if(shopCart==null||shopCart.isEmpty()){
			model.addAttribute("message","购物车为空");
		}else{
			model.addAttribute("shopCart", shopCart.getList());
		}
		return "cartProduct/shopCart";
	}
	
	@RequestMapping(value="/{pid}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int pid,HttpSession session){
		ShopCart shopCart = (ShopCart)session.getAttribute("ShopCart");
		Product product = productService.load(pid);
		shopCart.remove(product);
		session.setAttribute("ShopCart", shopCart);
		return "redirect:/cartProduct/shopCart";
	}
}
