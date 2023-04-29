package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemName;
import com.friendly.eco.exception.MemNameException;
import com.friendly.eco.exception.MemTypeException;

@Repository
public class MybatisMemNameDAO implements MemNameDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("MemName.selectAll");
	}

	@Override
	public MemName select(int mem_name_idx) {
		return sqlSessionTemplate.selectOne("MemName.select");
	}

	@Override
	public void insert(MemName memName) throws MemNameException {
		int result = sqlSessionTemplate.insert("MemName.insert", memName);
		if (result < 1) {
			throw new MemNameException("회원 등록 실패");
		}
	}

	@Override
	public void update(MemName memName) throws MemNameException {
		int result = sqlSessionTemplate.update("MemName.update", memName);
		if (result < 1) {
			throw new MemNameException("회원 등록 실패");
		}
	}

	@Override
	public void delete(int mem_name_idx) throws MemNameException {
		int result = sqlSessionTemplate.insert("MemName.delete", mem_name_idx);
		if (result < 1) {
			throw new MemNameException("회원 등록 실패");
		}
	}
}