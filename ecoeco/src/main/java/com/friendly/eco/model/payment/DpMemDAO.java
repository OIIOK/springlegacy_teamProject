package com.friendly.eco.model.payment;

import java.util.List;

import com.friendly.eco.domain.DpMem;

public interface DpMemDAO {
	public List selectAll(); 
	public DpMem select(int dp_mem_idx);
	public void insert(DpMem dpMem);
	public void update(DpMem dpMem);
	public void delete(int dp_mem_idx);
}
