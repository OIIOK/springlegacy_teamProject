package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemPass;
import com.friendly.eco.exception.MemPassException;
import com.friendly.eco.exception.MemTypeException;

@Repository
public class MybatisMemPassDAO implements MemPassDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public MemPass selectByLogin(MemPass memPass) {
		return sqlSessionTemplate.selectOne("MemPass.selectByLogin", memPass);
	}

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("MemPass.selectAll");
	}

	@Override
	public MemPass select(int memPass_idx) {
		return sqlSessionTemplate.selectOne("MemPass.select");
	}

	@Override
	public void insert(MemPass memPass) throws MemPassException {
		int result=sqlSessionTemplate.insert("MemPass.insert", memPass);
		if(result<1) {
			throw new MemPassException("비밀번호 입력 실패");
		}
	}

	@Override
	public void update(MemPass memPass) {
		int result=sqlSessionTemplate.insert("MemPass.insert", memPass);
		if(result<1) {
			throw new MemPassException("비밀번호 수정 실패");
		}
	}

	@Override
	public void delete(int memPass_idx) {
		int result=sqlSessionTemplate.insert("MemPass.insert", memPass_idx);
		if(result<1) {
			throw new MemPassException("비밀번호 삭제 실패");
		}
	}

	@Override
	public MemPass selectByPass(MemPass memPass) {
		return sqlSessionTemplate.selectOne("MemPass.selectByPass", memPass);
	}

	@Override
	public MemPass selectMemPassByPK(int mem_idx) {
		return sqlSessionTemplate.selectOne("MemPass.selectMemPassByPK", mem_idx);
	}

}
