package xianming.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import xianming.shop.model.Category;
import xianming.shop.model.Product;
import xianming.shop.service.ICategoryService;
import xianming.shop.service.IProductService;

@Controller("productAction")
@RequestMapping("/product")
public class ProductAction {

	private IProductService productService;
	private ICategoryService categoryService;
	
	public ICategoryService getCategoryService() {
		return categoryService;
	}
	@Resource
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public IProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute Product product,Model model){
		model.addAttribute("categorys", categoryService.list());
		return "product/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Product product,BindingResult br,
			@RequestParam("image")MultipartFile image,HttpServletRequest request) throws IOException{
		if(br.hasErrors()){
			return "product/add";
		}
		String realPath = request.getSession().getServletContext().getRealPath("/resources/image");
		System.out.println(realPath);
		File f = new File(realPath+"/"+image.getOriginalFilename());
		System.out.println(f.getName());
		product.setImg(image.getOriginalFilename());
		FileUtils.copyInputStreamToFile(image.getInputStream(), f);
		productService.add(product, product.getCategory().getId());
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		List<Product> list = productService.list();
		model.addAttribute("products", list);
		List<Category> categorys = categoryService.list();
		model.addAttribute("categorys", categorys);
		return "product/list";
	}
	
	@RequestMapping(value="/{c_id}/list",method=RequestMethod.GET)
	public String list(@PathVariable int c_id,Model model){
		model.addAttribute("products",productService.listByCid(c_id));
		model.addAttribute("categorys", categoryService.list());
		return "product/list";
	}
	
	@RequestMapping(value="/{id}/show",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model){
		model.addAttribute("product", productService.load(id));
		return "product/show";
	}
}
