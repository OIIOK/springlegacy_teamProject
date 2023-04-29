package com.friendly.eco.model.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.DpMem;
import com.friendly.eco.domain.Dpsit;

@Service
public class DpMemServiceImpl implements DpMemService{

	@Autowired
	private DpMemDAO dpMemDAO;
	
	@Override
	public List selectAll() {
		return dpMemDAO.selectAll();
	}

	@Override
	public DpMem select(int dp_mem_idx) {
		return dpMemDAO.select(dp_mem_idx);
	}

	@Override
	public void insert(DpMem dpMem) {
		dpMemDAO.insert(dpMem);
	}

	@Override
	public void update(DpMem dpMem) {
		dpMemDAO.update(dpMem);
	}

	@Override
	public void delete(int dp_mem_idx) {
		dpMemDAO.delete(dp_mem_idx);
	}
}
