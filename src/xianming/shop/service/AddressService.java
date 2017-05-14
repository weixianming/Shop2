package xianming.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xianming.shop.dao.IAddressDao;
import xianming.shop.model.Address;

@Service("addressService")
public class AddressService implements IAddressService {

	private IAddressDao addressDao;
	
	public IAddressDao getAddressDao() {
		return addressDao;
	}

	@Resource
	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public void add(Address address) {
		addressDao.add(address);
	}

	@Override
	public void delete(int id) {
		addressDao.delete(id);
	}

	@Override
	public void update(Address address) {
		addressDao.update(address);
	}

	@Override
	public Address load(int id) {
		return addressDao.load(id);
	}

	@Override
	public List<Address> list(int userId) {
		return addressDao.list("select add from Address add join fetch add.user u where add.user.id=?", userId);
	}

}
