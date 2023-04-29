package com.friendly.eco.model.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.ChallengeType;

@Service
public class ChallengeTypeServiceImpl implements ChallengeTypeService{
	@Autowired
	private ChallengeTypeDAO ChallengeTypeDAO;
	
	@Override
	public List selectAll() {
		return ChallengeTypeDAO.selectAll();
	}
}
