package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.SocietyMem;

@Service
public class SocietyMemServiceImpl implements SocietyMemService {

	@Autowired
	private SocietyMemDAO societyMemDAO;
	@Autowired
	private MemDAO memDAO;
	
	
	@Override
	public List selectAll() {
		return societyMemDAO.selectAll();
	}

	@Override
	public SocietyMem select(SocietyMem societyMem) {
		return societyMemDAO.select(societyMem);
	}

	@Override
	public void regist(SocietyMem societyMem, Mem mem) {
		
		//db저장
		System.out.println("society service에서의 mem 값은? : " + mem);
		memDAO.insert(mem);
		System.out.println("service에서의 mem 초기 값 : " + mem); 
		
		//각각 다른 테이블에 db를 넣어주기에, idx값을 동일하게 해줘야 함! -> idx값을 구해오자
		int mem_idx = mem.getMem_idx();
		System.out.println("soc service의 idx는 : " +  mem_idx);
		
		societyMem.getMem().setMem_idx(mem_idx); //idx값 삽입!

		societyMemDAO.insert(societyMem);
	}

	@Override
	public void update(SocietyMem societyMem) {
		societyMemDAO.update(societyMem);
	}

	@Override
	public void delete(int society_mem_idx) {
		societyMemDAO.delete(society_mem_idx);
	}
	
	
}
