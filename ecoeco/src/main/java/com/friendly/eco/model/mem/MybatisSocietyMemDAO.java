package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.SocietyMem;
import com.friendly.eco.exception.MemPhoneException;
import com.friendly.eco.exception.SocietyMemException;

@Repository
public class MybatisSocietyMemDAO implements SocietyMemDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("SoceityMem.selectAll");
	}

	@Override
	public SocietyMem select(SocietyMem societyMem) {
		return sqlSessionTemplate.selectOne("SocietyMem.select");
	}

	@Override
	public void insert(SocietyMem societyMem) throws SocietyMemException{
		int result=sqlSessionTemplate.insert("SocietyMem.insert", societyMem);
		if(result<1) {
			throw new SocietyMemException("단체 회원 등록 실패");
		}
	}

	@Override
	public void update(SocietyMem societyMem) throws SocietyMemException{
		int result=sqlSessionTemplate.update("SocietyMem.update", societyMem);
		if(result<1) {
			throw new SocietyMemException("단체 회원 수정 실패");
		}
	}

	@Override
	public void delete(int society_mem_idx) throws SocietyMemException{
		int result=sqlSessionTemplate.delete("SocietyMem.delete", society_mem_idx);
		if(result<1) {
			throw new SocietyMemException("단체 회원 삭제 실패");
		}
	}
	
}
