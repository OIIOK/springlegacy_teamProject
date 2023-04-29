package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemType;
import com.friendly.eco.exception.MemException;
import com.friendly.eco.exception.MemTypeException;

@Repository
public class MybatisMemTypeDAO implements MemTypeDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("MemType.selectAll");
	}

	@Override
	public MemType select(int mem_type_idx) {
		return sqlSessionTemplate.selectOne("MemType.select");
	}

	@Override
	public void insert(MemType memType) throws MemTypeException{
		int result=sqlSessionTemplate.insert("MemType.insert", memType);
		if(result<1) {
			throw new MemTypeException("회원 등록 실패");
		}
	}

	@Override
	public void update(MemType memType) throws MemTypeException{
		int result=sqlSessionTemplate.update("MemType.update", memType);
		if(result<1) {
			throw new MemTypeException("회원 등록 실패");
		}
	}

	@Override
	public void delete(int mem_type_idx) throws MemTypeException{
		int result=sqlSessionTemplate.delete("MemType.insert", mem_type_idx);
		if(result<1) {
			throw new MemTypeException("회원 등록 실패");
		}
	}

	@Override
	public MemType selectByIdx(int mem_type_idx) {
		return sqlSessionTemplate.selectOne("MemType.selectByIdx");
	}

}
