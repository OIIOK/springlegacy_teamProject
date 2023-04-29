package com.friendly.eco.model.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.DpMem;

@Repository
public class MybatisDpMemDAO implements DpMemDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("DpMem.selectAll");
	}

	@Override
	public DpMem select(int dp_mem_idx) {
		return sqlSessionTemplate.selectOne("DpMem.select", dp_mem_idx);
	}

	@Override
	public void insert(DpMem dpMem) {
		
	}

	@Override
	public void update(DpMem dpMem) {
		
	}

	@Override
	public void delete(int dp_mem_idx) {
		
	}

}
