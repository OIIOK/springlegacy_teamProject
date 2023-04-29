package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.MemEmail;

public interface MemEmailService {
	public List selectAll();
	public MemEmail select(int mem_email_idx);
	public void insert(MemEmail memEmail);
	public void update(MemEmail memEmail);
	public void delete(int mem_email_idx);
}
