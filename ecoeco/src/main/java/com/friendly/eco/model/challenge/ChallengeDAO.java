package com.friendly.eco.model.challenge;

import java.util.List;

import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.ChallengeState;

public interface ChallengeDAO {
	public List selectAll();
	public Challenge select(int challenge_idx);
	public void insert(Challenge challenge);
	public void update(Challenge challenge);
	public void delete(int challenge_idx);
}
