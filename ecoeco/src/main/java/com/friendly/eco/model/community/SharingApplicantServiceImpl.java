package com.friendly.eco.model.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.SharingApplicant;

@Service
public class SharingApplicantServiceImpl implements SharingApplicantService {
	
	@Autowired
	SharingApplicantDAO sharingApplicantDAO;

	@Override
	public List<SharingApplicant> selectBySharingPK(int sharing_idx) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		SharingApplicant sharingApplicant = new SharingApplicant();
		sharingApplicant.setMem(mem);
		// 임시로 회원 넣어줌
		
		return sharingApplicantDAO.selectBySharingPK(sharing_idx);
	}

	@Override
	public int selectCount(int sharing_idx) {

		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		SharingApplicant sharingApplicant = new SharingApplicant();
		sharingApplicant.setMem(mem);
		// 임시로 회원 넣어줌
		
		return sharingApplicantDAO.selectCount(sharing_idx);
	}

	@Override
	public SharingApplicant selectByWin(int applicant_win) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		SharingApplicant sharingApplicant = new SharingApplicant();
		sharingApplicant.setMem(mem);
		// 임시로 회원 넣어줌
		
		return sharingApplicantDAO.selectByWin(applicant_win);
	}

	@Override
	public void insert(SharingApplicant sharingApplicant) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		sharingApplicant.setMem(mem);
		// 임시로 회원 넣어줌
				
		sharingApplicantDAO.insert(sharingApplicant);
		
		//System.out.println("applicant_idx : "+ sharingApplicant.getApplicant_idx());
	}

	@Override
	public void deleteOne(int applicant_idx) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		SharingApplicant sharingApplicant = new SharingApplicant();
		sharingApplicant.setMem(mem);
		// 임시로 회원 넣어줌
		
		sharingApplicantDAO.deleteOne(applicant_idx);
	}

	@Override
	public void deleteBySharingPK(int sharing_idx) {
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		SharingApplicant sharingApplicant = new SharingApplicant();
		sharingApplicant.setMem(mem);
		// 임시로 회원 넣어줌
		
		sharingApplicantDAO.deleteBySharingPK(sharing_idx);
	}
}
