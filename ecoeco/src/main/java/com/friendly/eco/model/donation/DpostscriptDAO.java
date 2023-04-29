package com.friendly.eco.model.donation;

import java.util.List;

import com.friendly.eco.domain.Dpostscript;

public interface DpostscriptDAO {
	public List selectAll();
	public Dpostscript select(int dpostscript_idx);
	public void insert(Dpostscript dpostscript);
	public void update(Dpostscript dpostscript);
	public void delete(int dpostscript_idx);
}
