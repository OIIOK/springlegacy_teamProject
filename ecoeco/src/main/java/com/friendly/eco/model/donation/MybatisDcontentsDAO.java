package com.friendly.eco.model.donation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.exception.DcontentsException;

@Repository
public class MybatisDcontentsDAO implements DcontentsDAO{

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	public List selectOfMem(int mem_idx) {
		return sessionTemplate.selectList("Dcontents.selectOfMem", mem_idx);
	}
	
	public List selectAll() {
		return sessionTemplate.selectList("Dcontents.selectAll");
	}
	
	public List selectOfEnd() {
		return sessionTemplate.selectList("Dcontents.selectOfEnd");
	}
	
	public List selectOfAmount() {
		return sessionTemplate.selectList("Dcontents.selectOfAmount");
	}
	
	public Dcontents select(int dcontents_idx) {
		return sessionTemplate.selectOne("Dcontents.select", dcontents_idx);
	}
	
	public void insert(Dcontents dcontents) throws DcontentsException{
		int result=sessionTemplate.insert("Dcontents.insert", dcontents);
		if(result<1) {
			throw new DcontentsException("기부 글 등록 실패");
		}
	}

	public void update(Dcontents dcontents) throws DcontentsException{
		int result=sessionTemplate.update("Dcontents.update", dcontents);
		if(result<1) {
			throw new DcontentsException("기부 글 수정 실패");
		}
	}

	public void delete(int dcontents_idx) throws DcontentsException{
		int result=sessionTemplate.delete("Dcontents.delete", dcontents_idx);
		if(result<1) {
			throw new DcontentsException("기부 글 삭제 실패");
		}
	}


	}





	

