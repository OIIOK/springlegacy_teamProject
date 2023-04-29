package com.friendly.eco.model.community;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendly.eco.domain.ChatterComments;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.exception.ChatterCommentsException;

@Service
public class ChatterCommentsServiceImpl implements ChatterCommentsService {

	@Autowired
	ChatterCommentsDAO chatterCommentsDAO;

	@Override
	public List<ChatterComments> selectByChatterPK(int chatter_idx) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		ChatterComments chatterComments = new ChatterComments();
		chatterComments.setMem(mem);
		// 임시로 회원 넣어줌
		
		return chatterCommentsDAO.selectByChatterPK(chatter_idx);
	}

	@Override
	public int selectCount(int chatter_idx) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		ChatterComments chatterComments = new ChatterComments();
		chatterComments.setMem(mem);
		// 임시로 회원 넣어줌
		
		return chatterCommentsDAO.selectCount(chatter_idx);
	}

	@Override
	public void insert(ChatterComments chatterComments) throws ChatterCommentsException{
		
		System.out.println("이 시점에서 chatterComments : "+ chatterComments);
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		chatterComments.setMem(mem);
		// 임시로 회원 넣어줌
		
		System.out.println("임시로 멤버 넣고 chatterComments : "+ chatterComments);
		
		chatterCommentsDAO.insert(chatterComments);
	}

	@Override
	public void update(ChatterComments chatterComments) throws ChatterCommentsException{
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		chatterComments.setMem(mem);
		// 임시로 회원 넣어줌
		
		chatterCommentsDAO.update(chatterComments);
	}

	@Override
	public void deleteOne(int chattercomments_idx) throws ChatterCommentsException{
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		ChatterComments chatterComments = new ChatterComments();
		chatterComments.setMem(mem);
		// 임시로 회원 넣어줌
		
		chatterCommentsDAO.deleteOne(chattercomments_idx);
	}

	@Override
	public void deleteByChatterPK(int chatter_idx) throws ChatterCommentsException{
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		ChatterComments chatterComments = new ChatterComments();
		chatterComments.setMem(mem);
		// 임시로 회원 넣어줌
		
		chatterCommentsDAO.deleteByChatterPK(chatter_idx);
	}
}
