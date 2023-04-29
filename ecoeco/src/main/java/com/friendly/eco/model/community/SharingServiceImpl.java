package com.friendly.eco.model.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.Sharing;
import com.friendly.eco.domain.SharingApplicant;
import com.friendly.eco.exception.SharingException;
import com.friendly.eco.util.FileManager;
import com.mysql.fabric.xmlrpc.base.Member;

@Service
public class SharingServiceImpl implements SharingService {

	@Autowired
	private SharingDAO sharingDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private SharingApplicantDAO sharingApplicantDAO;

	@Override
	public List<Sharing> selectAll() {
		return sharingDAO.selectAll();
	}

	@Override
	public List<Sharing> selectBySCategoryPK(int sharingcategory_idx) {
		return sharingDAO.selectBySCategoryPK(sharingcategory_idx);
	}

	@Override
	public Sharing selectByPK(int sharing_idx) {
		return sharingDAO.selectByPK(sharing_idx);
	}

	@Override
	public void upgInsert(Sharing sharing, String dir) throws SharingException {

		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		sharing.setMem(mem);
		// 임시로 회원 넣어줌

		// 1) 파일 저장
		fileManager.saveSharing(sharing, dir);

		// 2)완성된 내용DTO에 채워주기
		sharingDAO.insert(sharing);
	}

	@Override
	public void upgUpdate(Sharing sharing, String dir) throws SharingException {
		
		
		
		// 임시로 회원 넣어줌
		Mem mem = new Mem();
		mem.setMem_idx(1);
		sharing.setMem(mem);
		// 임시로 회원 넣어줌

		// 1) 파일 저장
		fileManager.saveSharing(sharing, dir);

		// 2)완성된 내용DTO에 채워주기
		sharingDAO.update(sharing);
	}

	@Transactional
	@Override
	public int upgUpdateIndex(Sharing sharing, Mem mem) throws SharingException {
		System.out.println("serviceImpl upgUpdateIndex called ....");
		
		
		// 임시로 회원 넣어줌
				mem.setMem_idx(1);
				sharing.setMem(mem);
				// 임시로 회원 넣어줌
		
		
		//1) 인덱스(=신청자 수) 증가시키기
		int index = sharing.getSharing_random_index();
		//index++; //추가하는 거 어디서 하는거였지?? 매퍼에서!!!
		System.out.println("Service에서 index : "+ index);
		sharing.setSharing_random_index(index);
		sharingDAO.updateIndex(sharing); //문제있대
		
		//2) 레코드 한 줄 가져와 랜덤범위와 인덱스(=신청자 수) 비교하여 추첨결과 내기
		Sharing dto = sharingDAO.selectByPK(sharing.getSharing_idx());
		System.out.println("upgUpdateIndex에서 DTO : "+dto);
		
		int range = dto.getSharing_random_range();
		index = dto.getSharing_random_index();
		int result = 0; //결과 = 낙첨
		if(range == index) {
			result = 1; //결과 = 당첨
		}
		
		//3) 추첨결과 포함하여 신청 정보 등록하기
		SharingApplicant sharingApplicant = new SharingApplicant(); //빈 DTO 생성
		sharingApplicant.setSharing(sharing);
		sharingApplicant.setMem(mem);
		sharingApplicant.setApplicant_win(result);
		sharingApplicantDAO.insert(sharingApplicant);
		
		return result; //이러면 result에 0,1(낙첨, 당첨) 나오나??-----------------------------------------
	}

	@Override
	public void delete(int sharing_idx) throws SharingException {

		sharingDAO.delete(sharing_idx);
	}
}
