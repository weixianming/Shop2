package xianming.shop.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import xianming.shop.exception.ShopException;
import xianming.shop.model.Address;
import xianming.shop.model.User;
import xianming.shop.service.IAddressService;
import xianming.shop.service.IUserService;

@Controller("userAction")
@RequestMapping("/user")
public class UserAction {
	
	private IUserService userService;
	private IAddressService addressService;
	
	public IAddressService getAddressService() {
		return addressService;
	}
	
	@Resource
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}
	
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute User user,HttpSession session,HttpServletResponse response,HttpServletRequest request){
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser!=null){
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/product/list");
			throw new ShopException("无法访问");
		}
		return "user/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br){
		if(br.hasErrors()){
			return "user/add";
		}
		userService.add(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model,HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			return "redirect:/user/login";
		}else if(loginUser.getType()!=1){
			return "redirect:/product/list";
		}
		model.addAttribute("users", userService.list());
		return "user/list";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session,HttpServletResponse response,HttpServletRequest request){
		User u = userService.login(username, password);
		if(u==null){
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/user/login");
			throw new ShopException("用户名或密码不正确");
		}
		if(!u.getPassword().equals(password)){
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/user/login");
			throw new ShopException("用户名或密码不正确");
		}
		session.setAttribute("loginUser", u);
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	public String loginOut(HttpSession session){
		session.removeAttribute("loginUser");
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show(Model model,HttpSession session,HttpServletResponse response,HttpServletRequest request){
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/user/login");
			throw new ShopException("请先登录");
		}else{
			model.addAttribute("user", loginUser);
		}
		List<Address> addresses = addressService.list(loginUser.getId());
		if(addresses!=null){
			model.addAttribute("addresses", addresses);
		}
		
		return "user/show";
	}
	
}
