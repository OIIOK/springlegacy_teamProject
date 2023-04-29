package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemPhone;
import com.friendly.eco.exception.MemPhoneException;

@Repository
public class MybatisMemPhoneDAO implements MemPhoneDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("MemPhone.selectAll");
	}

	@Override
	public MemPhone select(int mem_phone_idx) {
		return sqlSessionTemplate.selectOne("MemPhone.select");
	}

	@Override
	public void insert(MemPhone memPhone) throws MemPhoneException{
		int result=sqlSessionTemplate.insert("MemPhone.insert", memPhone);
		if(result<1) {
			throw new MemPhoneException("회원 등록 실패");
		}
	}

	@Override
	public void update(MemPhone memPhone) throws MemPhoneException{
		int result=sqlSessionTemplate.update("MemPhone.update", memPhone);
		if(result<1) {
			throw new MemPhoneException("회원 등록 실패");
		}
	}

	@Override
	public void delete(int mem_phone_idx) throws MemPhoneException{
		int result=sqlSessionTemplate.delete("MemPhone.delete", mem_phone_idx);
		if(result<1) {
			throw new MemPhoneException("회원 등록 실패");
		}
	}

}
