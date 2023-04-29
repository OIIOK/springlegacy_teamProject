package com.friendly.eco.model.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.Challenger;

@Service
public class ChallengerServiceImpl implements ChallengerService{
	@Autowired
	private ChallengerDAO challengerDAO;
	

	@Override
	public List<Challenger> selectByMem(Challenger challenger) {
		return challengerDAO.selectByMem(challenger);
	}
	
	@Override
	public List<Challenger> selectByChallengerIdx(int challenger_idx) {
		return challengerDAO.selectByChallengeIdx(challenger_idx);
	}
	
	@Override
	public List selectAll() {
		return challengerDAO.selectAll();
	}

	@Override
	public Challenger select(int challenger_idx) {
		return challengerDAO.select(challenger_idx);
	}

	@Override
	public void insert(Challenger challenger) {
		challengerDAO.insert(challenger);
	}
}
