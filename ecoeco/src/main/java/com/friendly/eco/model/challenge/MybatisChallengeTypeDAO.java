package com.friendly.eco.model.challenge;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisChallengeTypeDAO implements ChallengeTypeDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTamplate.selectList("ChallengeType.selectAll");
	}
}
