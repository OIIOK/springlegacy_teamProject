package com.friendly.eco.model.community;

import java.util.List;
import com.friendly.eco.domain.Chatter;

public interface ChatterDAO {

	public List<Chatter> selectAll();
	public Chatter selectByPK(int chatter_idx); 
	public void insert(Chatter chatter);
	public void update(Chatter chatter);
	public void delete(int chatter_idx);
}
