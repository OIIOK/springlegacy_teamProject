package com.friendly.eco.model.challenge;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.ChallengeState;
import com.friendly.eco.exception.ChallengeException;
import com.friendly.eco.util.FileManager;

@Service
public class ChallengeServiceImpl implements ChallengeService{
	@Autowired
	private ChallengeDAO challengeDAO;	
	
	@Autowired
	private ChallengeStateDAO challengeStateDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		return challengeDAO.selectAll();
	}

	@Override
	public Challenge select(int challenge_idx) {
		return challengeDAO.select(challenge_idx);
	}

	@Override
	public void regist(Challenge challenge, String dir) throws ChallengeException{
		//챌린지 상태 가져오기
		ChallengeState challengeState=challengeStateDAO.selectByStateIdx();
		challenge.setChallengeState(challengeState);  //비어있는 dto에 상태값 채워주기
		
		//파일저장
		fileManager.save(challenge, dir);
		
		//챌린지 등록
		challengeDAO.insert(challenge);  //채워진 상태의 dto
		
	}

	@Override
	public void update(Challenge challenge) {
		challengeDAO.update(challenge);
	}

	@Override
	public void delete(int challenge_idx) {
		challengeDAO.delete(challenge_idx);
	}
}
