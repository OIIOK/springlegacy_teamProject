package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.SocietyMem;

public interface SocietyMemDAO {
	public List selectAll();
	public SocietyMem select(SocietyMem societyMem);
	public void insert(SocietyMem societyMem);
	public void update(SocietyMem societyMem);
	public void delete(int society_mem_idx);
}
