package com.friendly.eco.model.donation;

import java.util.List;

import com.friendly.eco.domain.Dcontents;

public interface DcontentsService {
	public List selectOfMem(int mem_idx);
	public List selectAll();
	public List selectOfEnd();
	public List selectOfAmount();
	public List selectOfChoice(int option_idx);
	public Dcontents select(int dcontents_idx);
	public void regist(Dcontents dcontents, String dir);
	public void update(Dcontents dcontents, String dir);
	public void delete(int dcontents_idx);
}
