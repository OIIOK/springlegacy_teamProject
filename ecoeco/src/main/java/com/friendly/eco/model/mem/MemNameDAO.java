package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemName;

public interface MemNameDAO {
	public List selectAll();
	public MemName select(int mem_name_idx);
	public void insert(MemName memName);
	public void update(MemName memName);
	public void delete(int mem_name_idx);
}
