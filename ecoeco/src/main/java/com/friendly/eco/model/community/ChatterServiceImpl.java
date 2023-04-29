package com.friendly.eco.model.community;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.exception.ChatterException;
import com.friendly.eco.util.FileManager;

@Service
public class ChatterServiceImpl implements ChatterService {

	@Autowired
	ChatterDAO chatterDAO;
	@Autowired
	FileManager filemanager;

	@Override
	public List<Chatter> selectAll() {
		return chatterDAO.selectAll();
	}

	@Override
	public Chatter selectByPK(int chatter_idx) {

		return chatterDAO.selectByPK(chatter_idx);
	}

	@Override
	public void upgInsert(Chatter chatter, String dir) throws ChatterException {

		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		chatter.setMem(mem);
		// 임시로 회원 넣어줌

		// 1) 파일 저장
		filemanager.saveChatter(chatter, dir);

		// 2) 완성된 내용 DTO에 채워주기
		chatterDAO.insert(chatter);
	}

	@Override
	public void upgUpdate(Chatter chatter, String dir) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		chatter.setMem(mem);
		// 임시로 회원 넣어줌
		
		// 1) 파일 저장
		filemanager.saveChatter(chatter, dir);
		
		// 2) 수정된 내용 DTO에 채워주기
		chatterDAO.update(chatter);
	}

	@Override
	public void delete(int chatter_idx) {
		chatterDAO.delete(chatter_idx);
	}

	@Override
	public void update(Chatter chatter) {
		chatterDAO.update(chatter);
	}

}
