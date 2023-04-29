package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemPass;

@Service
public class MemPassServiceImpl implements MemPassService{

	@Autowired
	MemPassDAO memPassDAO;

	@Override
	public MemPass selectByLogin(MemPass memPass) {
		return memPassDAO.selectByLogin(memPass);
	}

	@Override
	public List selectAll() {
		return memPassDAO.selectAll();
	}

	@Override
	public MemPass select(int memPass_idx) {
		return memPassDAO.select(memPass_idx);
	}

	@Override
	public void insert(MemPass memPass) {
		memPassDAO.insert(memPass);
	}

	@Override
	public void update(MemPass memPass) {
		memPassDAO.update(memPass);
	}

	@Override
	public void delete(int memPass_idx) {
		memPassDAO.delete(memPass_idx);
	}

	@Override
	public MemPass selectByPass(MemPass memPass) {
		return memPassDAO.selectByPass(memPass);
	}

	@Override
	public MemPass selectMemPassByPK(int mem_idx) {
		return memPassDAO.selectMemPassByPK(mem_idx);
	}
	
	
	
}
