package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemEmail;
import com.friendly.eco.exception.MemEmailException;

@Repository
public class MybatisMemEmailDAO implements MemEmailDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("MemEmail.selectAll");
	}

	@Override
	public MemEmail select(int mem_email_idx) {
		return sqlSessionTemplate.selectOne("MemEmail.select");
	}

	@Override
	public void insert(MemEmail memEmail) throws MemEmailException{
		// TODO Auto-generated method stub
		int result=sqlSessionTemplate.insert("MemEmail.insert", memEmail);
		if(result<1) {
			throw new MemEmailException("회원 등록 실패");
		}
	}

	@Override
	public void update(MemEmail memEmail) {
		// TODO Auto-generated method stub
		int result=sqlSessionTemplate.update("MemEmail.update", memEmail);
		if(result<1) {
			throw new MemEmailException("회원 등록 실패");
		}
	}

	@Override
	public void delete(int mem_email_idx) {
		// TODO Auto-generated method stub
		int result=sqlSessionTemplate.delete("MemEmail.delete", mem_email_idx);
		if(result<1) {
			throw new MemEmailException("회원 등록 실패");
		}
	}

}
