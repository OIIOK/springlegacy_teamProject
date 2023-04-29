package com.friendly.eco.model.payment;

import java.util.List;

import com.friendly.eco.domain.Dpsit;

public interface DpsitService {
	public List selectAll();
	public Dpsit select(int dpsit_idx);
	public void insert(Dpsit dpsit); 
	public void update(Dpsit dpsit);
	public void delete(int dpsit_idx);
}