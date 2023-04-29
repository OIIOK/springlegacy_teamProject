package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemPhone;

@Service
public class MemPhoneServiceImpl implements MemPhoneService{

	@Autowired
	private MemPhoneDAO memPhoneDAO;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return memPhoneDAO.selectAll();
	}

	@Override
	public MemPhone select(int mem_phone_idx) {
		// TODO Auto-generated method stub
		return memPhoneDAO.select(mem_phone_idx);
	}

	@Override
	public void insert(MemPhone memPhone) {
		// TODO Auto-generated method stub
		memPhoneDAO.insert(memPhone);
	}

	@Override
	public void update(MemPhone memPhone) {
		// TODO Auto-generated method stub
		memPhoneDAO.update(memPhone);
	}

	@Override
	public void delete(int mem_phone_idx) {
		// TODO Auto-generated method stub
		memPhoneDAO.delete(mem_phone_idx);
	}
	
}
