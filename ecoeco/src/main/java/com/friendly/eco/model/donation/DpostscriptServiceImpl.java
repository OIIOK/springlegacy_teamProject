package com.friendly.eco.model.donation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.domain.Dpostscript;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.exception.DpostscriptException;

@Service
public class DpostscriptServiceImpl implements DpostscriptService{

	@Autowired
	private DpostscriptDAO dpostscriptDAO;
	public List selectAll() {
		return dpostscriptDAO.selectAll();
	}

	public Dpostscript select(int dpostscript_idx) {
		return dpostscriptDAO.select(dpostscript_idx);
	}

	public void insert(Dpostscript dpostscript) throws DpostscriptException{
		Mem mem  = new Mem();
		mem.setMem_idx(2);
		Dcontents dcontents = new Dcontents();
		dcontents.setDcontents_idx(43);
		dpostscript.setMem(mem);
		dpostscript.setDcontents(dcontents);
		
		dpostscriptDAO.insert(dpostscript);
	}

	public void update(Dpostscript dpostscript) throws DpostscriptException{
		dpostscriptDAO.update(dpostscript);
	}

	public void delete(int dpostscript_idx) throws DpostscriptException{
		dpostscriptDAO.delete(dpostscript_idx);
	}
	
}
