package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemBirth;

@Service
public class MemBirthServiceImpl implements MemBirthService{
	
	@Autowired
	private MemBirthDAO memBirthDAO;

	@Override
	public List selectAll() {
		return memBirthDAO.selectAll();
	}

	@Override
	public MemBirth select(int mem_birth_idx) {
		// TODO Auto-generated method stub
		return memBirthDAO.select(mem_birth_idx);
	}

	@Override
	public void insert(MemBirth memBirth) {
		// TODO Auto-generated method stub
		memBirthDAO.insert(memBirth);
	}

	@Override
	public void update(MemBirth memBirth) {
		// TODO Auto-generated method stub
		memBirthDAO.update(memBirth);
	}

	@Override
	public void delete(int mem_birth_idx) {
		// TODO Auto-generated method stub
		memBirthDAO.delete(mem_birth_idx);
	}
	
	
}
