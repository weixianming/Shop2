package xianming.shop.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xianming.shop.model.Address;
import xianming.shop.model.User;
import xianming.shop.service.IAddressService;

@Controller("addressAction")
@RequestMapping("/address")
public class AddressAction {
	
	private IAddressService addressService;
	
	public IAddressService getAddressService() {
		return addressService;
	}
	
	@Resource
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute Address address,HttpSession session){
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			return "redirect:/user/login";
		}
		return "address/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Address address,BindingResult br,HttpSession session){
		if(br.hasErrors()){
			return "address/add";
		}
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			return "redirect:/user/login";
		}
		address.setUser(loginUser);
		addressService.add(address);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/{a_id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int a_id,HttpSession session){
		addressService.delete(a_id);
		return "redirect:/user/show";
	}
}
