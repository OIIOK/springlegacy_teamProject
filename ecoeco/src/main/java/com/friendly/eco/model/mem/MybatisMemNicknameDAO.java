package com.friendly.eco.model.mem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.MemNickname;
import com.friendly.eco.exception.MemNicknameException;
import com.friendly.eco.exception.MemPhoneException;

@Repository
public class MybatisMemNicknameDAO implements MemNicknameDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public MemNickname selectByMember(MemNickname memNickname) {
		return sqlSessionTemplate.selectOne("MemNickname.selectByMember");
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("MemNickname.selectAll");
	}

	@Override
	public MemNickname select(int mem_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("MemNickname.select");
	}

	@Override
	public void insert(MemNickname memNickname) throws MemNicknameException{
		int result=sqlSessionTemplate.insert("MemNickname.insert", memNickname);
		if(result<1) {
			throw new MemNicknameException("닉네임 등록 실패");
		}
	}

	@Override
	public void update(MemNickname memNickname) throws MemNicknameException{
		int result=sqlSessionTemplate.update("MemNickname.update", memNickname);
		if(result<1) {
			throw new MemNicknameException("닉네임 수정 실패");
		}		
	}

	@Override
	public void delete(int mem_nickname_idx) throws MemNicknameException {
		int result=sqlSessionTemplate.delete("MemNickname.delete", mem_nickname_idx);
		if(result<1) {
			throw new MemNicknameException("닉네임 삭제 실패");
		}		
	}
	
}
