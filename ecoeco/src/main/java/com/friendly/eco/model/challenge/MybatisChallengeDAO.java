package com.friendly.eco.model.challenge;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.ChallengeState;
import com.friendly.eco.exception.ChallengeException;

@Repository
public class MybatisChallengeDAO implements ChallengeDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTamplate.selectList("Challenge.selectAll");
	}

	@Override
	public Challenge select(int challenge_idx) {
		return sqlSessionTamplate.selectOne("Challenge.select", challenge_idx);
	}

	@Override
	public void insert(Challenge challenge) throws ChallengeException{
		int result= sqlSessionTamplate.insert("Challenge.insert", challenge);
		if(result<1) {
		 throw new ChallengeException("챌린지 등록 실패");
		}
	}

	@Override
	public void update(Challenge challenge) throws ChallengeException{
		int result=sqlSessionTamplate.update("Challenge.update", challenge);
		if(result<1) {
			throw new ChallengeException("챌린지 수정 실패");
		}
	}

	@Override
	public void delete(int challenge_idx) throws ChallengeException{
		int result=sqlSessionTamplate.delete("Challenge.delete", challenge_idx);
		if(result<1) {
			throw new ChallengeException("챌린지 삭제 실패");
		}
	}
}