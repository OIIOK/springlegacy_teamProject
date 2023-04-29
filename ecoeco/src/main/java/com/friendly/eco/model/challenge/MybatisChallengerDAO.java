package com.friendly.eco.model.challenge;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.friendly.eco.domain.Challenger;
import com.friendly.eco.exception.ChallengerException;

@Component
public class MybatisChallengerDAO implements ChallengerDAO{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private SqlSessionTemplate sqlSessionTamplate;

	@Override
	public List<Challenger> selectByMem(Challenger challenger) {
		return sqlSessionTamplate.selectList("Challenger.selectByMem", challenger);
	}
	
	@Override
	public List<Challenger> selectByChallengeIdx(int challenge_idx) {
		logger.info("넘겨받은 challenge_idx is "+challenge_idx);
		return sqlSessionTamplate.selectList("Challenger.selectByChallengeIdx", challenge_idx);
	}
	
	@Override
	public List selectAll() {
		return sqlSessionTamplate.selectList("Challenger.selectAll");
	}

	@Override
	public Challenger select(int challenger_idx) {
		return sqlSessionTamplate.selectOne("Challenger.select", challenger_idx);
	}

	@Override
	public void insert(Challenger challenger) throws ChallengerException {
		int result=sqlSessionTamplate.insert("Challenger.insert", challenger);
		logger.info("result is "+result);
		
		if(result<0) {
			throw new ChallengerException("챌린지 참여 실패");
		}
	}
}
