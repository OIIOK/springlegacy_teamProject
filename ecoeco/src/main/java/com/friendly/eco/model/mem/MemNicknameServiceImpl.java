package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.MemNickname;

@Service
public class MemNicknameServiceImpl implements MemNicknameService{

	@Autowired
	public MemNicknameDAO memNicknameDAO;
	
	@Override
	public MemNickname selectByMember(MemNickname memNickname) {
		// TODO Auto-generated method stub
		return memNicknameDAO.selectByMember(memNickname);
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return memNicknameDAO.selectAll();
	}

	@Override
	public MemNickname select(int mem_idx) {
		// TODO Auto-generated method stub
		return memNicknameDAO.select(mem_idx);
	}

	@Override
	public void insert(MemNickname memNickname) {
		// TODO Auto-generated method stub
		memNicknameDAO.insert(memNickname);
	}

	@Override
	public void update(MemNickname memNickname) {
		// TODO Auto-generated method stub
		memNicknameDAO.update(memNickname);
	}

	@Override
	public void delete(int mem_nickname_idx) {
		// TODO Auto-generated method stub
		memNicknameDAO.delete(mem_nickname_idx);
	}
	
}
