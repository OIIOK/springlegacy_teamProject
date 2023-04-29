package com.friendly.eco.model.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.Dpsit;
import com.friendly.eco.exception.DpsitException;

@Service
public class DpsitServiceImpl implements DpsitService{

	@Autowired
	private DpsitDAO dpsitDAO;
	
	@Override
	public List selectAll() {
		return dpsitDAO.selectAll();
	}

	public Dpsit select(int dpsit_idx) {
		return dpsitDAO.select(dpsit_idx);
	}

	public void insert(Dpsit dpsit) throws DpsitException{
		dpsitDAO.insert(dpsit);
	}

	@Override
	public void update(Dpsit dpsit) throws DpsitException{
		dpsitDAO.update(dpsit);
	}

	@Override
	public void delete(int dpsit_idx) throws DpsitException{
		dpsitDAO.delete(dpsit_idx);
	}

}