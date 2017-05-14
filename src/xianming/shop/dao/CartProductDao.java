package xianming.shop.dao;

import org.springframework.stereotype.Repository;

import xianming.shop.model.CartProduct;

@Repository("cartProductDao")
public class CartProductDao extends BaseDao<CartProduct> implements ICartProductDao {

}
