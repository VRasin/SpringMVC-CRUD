package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.Phone;
import spring.dao.PhonesDAO;

@Service("phoneService")
public class PhoneService {

	private PhonesDAO phonesDao;
	
	@Autowired
	public void setPhonesDao(PhonesDAO phonesDao) {
		this.phonesDao = phonesDao;
	}
	
	public List<Phone> getPhones(){
		return phonesDao.getAllPhones();
	}
	
	public Phone getPhone(int id) {
		return phonesDao.getPhoneById(id);
	}
	
	public boolean createPhone(Phone phone) {
		return phonesDao.insert(phone);
	}
	
	public boolean deletePhone(int id) {
		return phonesDao.delete(id);
	}
	
	public boolean editPhone(Phone phone) {
		return phonesDao.update(phone);
	}
}
