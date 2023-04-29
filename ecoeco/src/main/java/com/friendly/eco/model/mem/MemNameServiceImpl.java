package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemName;
import com.friendly.eco.domain.MemType;

@Service
public class MemNameServiceImpl implements MemNameService{

	@Autowired
	private MemNameDAO memNameDAO;

	@Override
	public List selectAll() {
		return memNameDAO.selectAll();
	}

	@Override
	public MemName select(int mem_name_idx) {
		return memNameDAO.select(mem_name_idx);
	}

	@Override
	public void insert(MemName memName) {
		memNameDAO.insert(memName);
	}

	@Override
	public void update(MemName memName) {
		memNameDAO.update(memName);
	}

	@Override
	public void delete(int mem_name_idx) {
		memNameDAO.delete(mem_name_idx);
	}
	


}
