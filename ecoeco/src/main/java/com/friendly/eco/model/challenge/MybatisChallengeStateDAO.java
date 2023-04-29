package com.friendly.eco.model.challenge;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.ChallengeState;

@Repository
public class MybatisChallengeStateDAO implements ChallengeStateDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public ChallengeState selectByStateIdx() {
		return sqlSessionTamplate.selectOne("ChallengeState.selectByStateIdx");
	}
}
