package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.Mem;
import com.friendly.eco.exception.MemException;

@Repository
public class MybatisMemDAO implements MemDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Mem.selectAll");
	}

	@Override
	public Mem select(String mem_id) {
		return sqlSessionTemplate.selectOne("Mem.select", mem_id);
	}

	@Override
	public void insert(Mem mem) throws MemException{
		int result=sqlSessionTemplate.insert("Mem.insert", mem);
		if(result<1) {
			throw new MemException("회원 등록 실패");
		}
	}

	@Override
	public void update(Mem mem) throws MemException{
		int result=sqlSessionTemplate.update("Mem.update", mem);
		if(result<1)
			throw new MemException("회원 수정 실패");
	}

	@Override
	public void delete(int mem_idx) throws MemException {
		int result=sqlSessionTemplate.delete("Mem.delete", mem_idx);
		if(result<1)
			throw new MemException("회원 삭제 실패");
	}

	@Override
	public Mem login(Mem mem) {
		return sqlSessionTemplate.selectOne("Mem.login", mem);
	}

	@Override
	public Mem selectById(Mem mem) {
		return sqlSessionTemplate.selectOne("Mem.selectById", mem);
	}

	@Override
	public void insertBysns(Mem mem) {
		int result=sqlSessionTemplate.insert("Mem.insertBysns", mem);
		if(result<1) {
			throw new MemException("회원 등록 실패");
		}
	}

	@Override
	public Mem selectByIdx(Mem mem) {
		return sqlSessionTemplate.selectOne("Mem.selectByIdx", mem);
	}


	
	
	
}
