package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemPhone;

public interface MemPhoneDAO {
	public List selectAll();
	public MemPhone select(int mem_phone_idx);
	public void insert(MemPhone memPhone);
	public void update(MemPhone memPhone);
	public void delete(int mem_phone_idx);
}
