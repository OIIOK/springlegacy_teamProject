package com.friendly.eco.model.donation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.Donator;
import com.friendly.eco.exception.DonatorException;

@Repository
public class MybatisDonatorDAO implements DonatorDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List selectAll() {
		return sqlSessionTemplate.selectList("Donator.selectAll");
	}

	public List selectByDcontents(int dcontents_idx) {
		return sqlSessionTemplate.selectOne("Donator.selectByDcontents", dcontents_idx);
	}

	public void insert(Donator donator) throws DonatorException{
		int result=sqlSessionTemplate.insert("Donator.insert", donator);
		if(result<1) {
			throw new DonatorException("기부자 등록 실패");
		}
	}

	public void update(Donator donator) throws DonatorException{
		int result=sqlSessionTemplate.update("Donator.update", donator);
		if(result<1) {
			throw new DonatorException("기부자 수정 실패");
		}
	}

	@Override
	public void delete(int dcontents_idx) throws DonatorException{
		int result=sqlSessionTemplate.delete("Donator.delete", dcontents_idx);
		if(result<1) {
			throw new DonatorException("기부자ㅣ삭제 실패");
		}
	}

}
