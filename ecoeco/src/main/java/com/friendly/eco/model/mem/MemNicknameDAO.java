package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemNickname;

public interface MemNicknameDAO {
	public MemNickname selectByMember(MemNickname memNickname);
	public List selectAll();
	public MemNickname select(int mem_idx);
	public void insert(MemNickname memNickname);
	public void update(MemNickname memNickname);
	public void delete(int mem_nickname_idx);
}
