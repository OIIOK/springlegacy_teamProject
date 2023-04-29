package com.friendly.eco.model.challenge;

import java.util.List;

import com.friendly.eco.domain.Challenger;

//챌린저에 관련된 CRUD
public interface ChallengerDAO {
	public List<Challenger> selectByChallengeIdx(int challenge_idx);
	public List<Challenger> selectByMem(Challenger challenger);
	public List selectAll();
	public Challenger select(int challenger_idx);
	public void insert(Challenger challenger);
}
