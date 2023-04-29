package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemPass;

public interface MemPassDAO {
	public MemPass selectMemPassByPK(int mem_idx);
	public MemPass selectByLogin(MemPass memPass);
	public MemPass selectByPass(MemPass memPass);
	public List selectAll();
	public MemPass select(int memPass_idx);
	public void insert(MemPass memPass);
	public void  update(MemPass memPass);
	public void delete(int memPass_idx);
}
