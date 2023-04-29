package com.friendly.eco.model.challenge;

import java.util.List;

import com.friendly.eco.domain.Challenger;

public interface ChallengerService {
	public List<Challenger> selectByChallengerIdx(int challenger_idx);
	public List<Challenger> selectByMem(Challenger challenger);
	public List selectAll();
	public Challenger select(int challenger_idx);
	public void insert(Challenger challenger);
}
