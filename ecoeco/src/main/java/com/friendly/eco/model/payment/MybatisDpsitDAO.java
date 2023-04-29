package com.friendly.eco.model.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.Dpsit;

@Repository
public class MybatisDpsitDAO implements DpsitDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Dpsit.selectAll");
	}

	@Override
	public Dpsit select(int dpsit_idx) {
		return sqlSessionTemplate.selectOne("Dpsit.select", dpsit_idx);
	}

	@Override
	public void insert(Dpsit dpsit) {
		
	}

	@Override
	public void update(Dpsit dpsit) {
		
	}

	@Override
	public void delete(int dpsit_idx) {
		
	}

}
