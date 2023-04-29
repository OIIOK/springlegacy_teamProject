package com.friendly.eco.model.community;

import java.util.List;

import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.Sharing;

public interface SharingService {

	public List<Sharing> selectAll();
	public List<Sharing> selectBySCategoryPK(int sharingcategory_idx);
	public Sharing selectByPK(int sharing_idx);
	public void upgInsert(Sharing sharing, String dir); // 섬네일 저장 기능 추가 (dir = 주소)
	public void upgUpdate(Sharing sharing, String dir); // 섬네일 저장 기능 추가 (dir = 주소)
	public int upgUpdateIndex(Sharing sharing, Mem mem); //applicant insert 기능 추가
	public void delete(int sharing_idx);
}
