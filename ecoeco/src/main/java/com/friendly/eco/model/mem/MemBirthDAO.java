package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemBirth;

public interface MemBirthDAO {
	public List selectAll();
	public MemBirth select(int mem_birth_idx);
	public void insert(MemBirth memBirth);
	public void update(MemBirth memBirth);
	public void delete(int mem_birth_idx);
}
