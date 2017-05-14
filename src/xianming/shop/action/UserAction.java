package xianming.shop.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opensymphony.module.sitemesh.parser.TokenizedHTMLPage;

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
	public String add(@ModelAttribute User user){
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
	public String list(Model model){
		model.addAttribute("users", userService.list());
		return "user/list";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		User u = userService.login(username, password);
		session.setAttribute("loginUser", u);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	public String loginOut(HttpSession session){
		session.removeAttribute("loginUser");
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show(Model model,HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
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
