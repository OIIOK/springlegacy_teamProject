package com.friendly.eco.model.donation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.exception.DcontentsException;
import com.friendly.eco.util.DateManager;
import com.friendly.eco.util.FileManager;

@Service
public class DcontentsServiceImpl implements DcontentsService{
	@Autowired
	private DcontentsDAO dcontentsDAO;
	
	@Autowired
	private FileManager filemanager;
	
	
	//회원별 조회
	public List selectOfMem(int mem_idx) {
		return dcontentsDAO.selectOfMem(mem_idx);
	}
	
	//최신순 조회
	public List selectAll() {
		return dcontentsDAO.selectAll();
	}

	//마감순 조회
	public List selectOfEnd() {
		return dcontentsDAO.selectOfEnd();
	}
	
	public List selectOfAmount() {
		return dcontentsDAO.selectOfAmount();
	}

	public List selectOfChoice(int option_idx) {
		System.out.println("service의 option_idx는?"+option_idx);
		List dcontentsList=null;
		
		if(option_idx==0) {//최신순
			dcontentsList =dcontentsDAO.selectAll();
		}else if(option_idx==1){//모집금액 순
			dcontentsList =dcontentsDAO.selectOfAmount();
			
		}else if(option_idx==3) {//종료임박순
			dcontentsList =dcontentsDAO.selectOfEnd();
		}
		return dcontentsList;
	}
	
	//모집금액 순
	public Dcontents select(int dcontents_idx) {
		return dcontentsDAO.select(dcontents_idx);
	}
	
	public void regist(Dcontents dcontents, String dir) throws DcontentsException{
		Mem mem  = new Mem();
		mem.setMem_idx(2);
		dcontents.setMem(mem);
		
		// 1) 파일 저장
		filemanager.saveDcontents(dcontents, dir);
		// 2) 완성된 내용 DTO에 채워주기
		dcontentsDAO.insert(dcontents);
	}

	public void update(Dcontents dcontents, String dir) throws DcontentsException{
		
		System.out.println("기존 이미지 파일은?"+dcontents.getDcontents_thumimg());
		//1) 기존 파일 삭제?
		filemanager.deleteFile(dir+dcontents.getDcontents_thumimg());
		
		//2) 파일저장
		filemanager.saveDcontents(dcontents, dir);
		
		//3) 수정
		dcontentsDAO.update(dcontents);
	}

	public void delete(int dcontents_idx) throws DcontentsException{
		dcontentsDAO.delete(dcontents_idx);
	}




}
