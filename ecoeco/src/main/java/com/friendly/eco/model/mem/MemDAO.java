package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.Mem;

public interface MemDAO {
	public Mem selectById(Mem mem);
	public Mem login(Mem mem);
	public List selectAll();
	public Mem select(String mem_id);
	public Mem selectByIdx(Mem mem);
	public void insert(Mem mem);
	public void insertBysns(Mem mem);
	public void update(Mem mem);
	public void delete(int mem_idx);
}
