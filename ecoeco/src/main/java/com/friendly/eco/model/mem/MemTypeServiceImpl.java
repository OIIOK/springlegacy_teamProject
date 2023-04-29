package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemType;

@Service
public class MemTypeServiceImpl implements MemTypeService{
	@Autowired
	MemTypeDAO memTypeDAO;
	
	public List selectAll() {
		return memTypeDAO.selectAll();
	}

	public MemType select(int mem_type_idx) {
		return memTypeDAO.select(mem_type_idx);
	}

	public void insert(MemType memType) {
		memTypeDAO.insert(memType);
	}

	public void update(MemType memType) {
		memTypeDAO.update(memType);
	}

	public void delete(int mem_type_idx) {
		memTypeDAO.delete(mem_type_idx);
	}

	@Override
	public MemType selectByIdx(int mem_type_idx) {
		return memTypeDAO.selectByIdx(mem_type_idx);
	}

}
