package xianming.shop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xianming.shop.model.Category;
import xianming.shop.service.ICategoryService;

@Controller("categoryAction")
@RequestMapping("/category")
public class CategoryAction {

	private ICategoryService categoryService;
	
	public ICategoryService getCategoryService() {
		return categoryService;
	}
	@Resource
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute Category category){
		return "category/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Category category,BindingResult br){
		if(br.hasErrors()){
			return "category/add";
		}
		System.out.println(category.getName());
		categoryService.add(category);
		return "redirect:/category/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("categorys", categoryService.list());
		return "category/list";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		categoryService.delete(id);
		return "redirect:/category/list";
	}
}
