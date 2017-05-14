package xianming.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import xianming.shop.service.ICartProductService;


public class ShopCart {
	
	
	private List<CartProduct> list;
	private boolean isEmpty;

	public ShopCart() {
		list = new ArrayList<CartProduct>();
		isEmpty = true;
	}
	
	public List<CartProduct> getList() {
		return list;
	}
	
	public void setList(List<CartProduct> list) {
		this.list = list;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void add(Product product,int number){
		//保留小数点后2位小数
		BigDecimal b = new BigDecimal((double)product.getPrice()*number);
		CartProduct cp = new CartProduct();
		cp.setNumber(number);
		cp.setPrice(b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		cp.setProduct(product);
		list.add(cp);
		this.setEmpty(false);
	}
	
	public void cleanCart(){
		list.clear();
		isEmpty = true;
	}
	
	public void remove(Product product){
		Iterator<CartProduct> iterator = list.iterator();
		while(iterator.hasNext()){
			CartProduct cp = iterator.next();
			if(cp.getProduct().getName().equals(product.getName())){
				iterator.remove();
			}
		}
		if(list.size()==0){
			isEmpty=true;
		}

	}
}
