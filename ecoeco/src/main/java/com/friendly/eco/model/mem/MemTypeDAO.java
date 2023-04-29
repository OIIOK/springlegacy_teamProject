package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemType;

public interface MemTypeDAO {
	public MemType selectByIdx(int mem_type_idx);
	public List selectAll();
	public MemType select(int mem_type_idx);
	public void insert(MemType memType);
	public void update(MemType memType);
	public void delete(int mem_type_idx);
}
