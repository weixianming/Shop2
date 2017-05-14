package xianming.shop.dao;

import org.springframework.stereotype.Repository;

import xianming.shop.model.Address;

@Repository("addressDao")
public class AddressDao extends BaseDao<Address> implements IAddressDao {

}
