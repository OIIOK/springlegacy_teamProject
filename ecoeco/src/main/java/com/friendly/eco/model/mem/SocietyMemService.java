package com.friendly.eco.model.mem;

import java.util.List;

import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.SocietyMem;

public interface SocietyMemService {
		public List selectAll();
		public SocietyMem select(SocietyMem societyMem);
		public void regist(SocietyMem societyMem, Mem mem);
		public void update(SocietyMem societyMem);
		public void delete(int society_mem_idx);
	}

