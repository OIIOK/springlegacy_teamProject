package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemEmail;

@Service
public class MemEmailServiceImpl implements MemEmailService{

	@Autowired
	private MemEmailDAO memEmailDAO;
	
	@Override
	public List selectAll() {
		return memEmailDAO.selectAll();
	}

	@Override
	public MemEmail select(int mem_email_idx) {
		return memEmailDAO.select(mem_email_idx);
	}

	@Override
	public void insert(MemEmail memEmail) {
		memEmailDAO.insert(memEmail);
	}

	@Override
	public void update(MemEmail memEmail) {
		memEmailDAO.update(memEmail);
	}

	@Override
	public void delete(int mem_email_idx) {
		memEmailDAO.delete(mem_email_idx);
	}
	
}
