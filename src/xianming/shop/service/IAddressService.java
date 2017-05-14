package xianming.shop.service;

import java.util.List;

import xianming.shop.model.Address;

public interface IAddressService {
	public void add(Address address);
	public void delete(int id);
	public void update(Address address);
	public Address load(int id);
	public List<Address> list(int userId);
}
