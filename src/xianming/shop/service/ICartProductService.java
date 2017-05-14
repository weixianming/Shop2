package xianming.shop.service;

import java.util.List;

import xianming.shop.model.CartProduct;

public interface ICartProductService {
	public void add(CartProduct cartProduct);
	public void delete(int id);
	public void update(CartProduct cartProduct);
	public List<CartProduct> listByOrderId(int o_id);
}
