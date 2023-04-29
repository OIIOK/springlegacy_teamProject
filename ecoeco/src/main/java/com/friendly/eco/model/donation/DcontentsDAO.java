package com.friendly.eco.model.donation;

import java.util.List;

import com.friendly.eco.domain.Dcontents;

public interface DcontentsDAO {
	public List selectOfMem(int mem_idx);
	public List selectAll();
	public List selectOfEnd();
	public List selectOfAmount();
	public Dcontents select(int dcontents_idx);
	public void insert(Dcontents dcontents);
	public void update(Dcontents dcontents);
	public void delete(int dcontents_idx);
	
}
