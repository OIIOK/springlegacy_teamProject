package com.friendly.eco.model.challenge;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.ChallPhoto;

@Repository
public class MybatisChallPhotoDAO implements ChallPhotoDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("ChallPhoto.selectAll");
		
	}

	@Override
	public ChallPhoto select(int chall_photo_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("ChallPhoto.select", chall_photo_idx);
	}
	@Override
	public List selectByChallenger(int challenger_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("ChallPhoto.selectByChallenger", challenger_idx);
	}
}
