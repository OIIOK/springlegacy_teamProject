package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemBirth;
import com.friendly.eco.exception.MemBirthException;
import com.friendly.eco.exception.MemTypeException;

@Repository
public class MybatisMemBirthDAO implements MemBirthDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("MemBirth.selectAll");
	}

	@Override
	public MemBirth select(int mem_birth_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("MemBirth.select");
	}

	@Override
	public void insert(MemBirth memBirth) throws MemBirthException{
		int result=sqlSessionTemplate.insert("MemBirth.insert", memBirth);
		if(result<1) {
			throw new MemBirthException("회원 등록 실패");
		}
	}

	@Override
	public void update(MemBirth memBirth) {
		// TODO Auto-generated method stub
		int result=sqlSessionTemplate.update("MemBirth.update", memBirth);
		if(result<1) {
			throw new MemBirthException("회원 등록 실패");
		}
	}

	@Override
	public void delete(int mem_birth_idx) {
		// TODO Auto-generated method stub
		int result=sqlSessionTemplate.delete("MemBirth.delete", mem_birth_idx);
		if(result<1) {
			throw new MemBirthException("회원 등록 실패");
		}
	}
	
}
