package com.friendly.eco.model.donation;

import java.util.List;

import com.friendly.eco.domain.Donator;

public interface DonatorDAO {
	public List selectAll();
	public List selectByDcontents(int dcontents_idx);
	public void insert(Donator donator);
	public void update(Donator donator);
	public void delete(int dcontents_idx);
}
