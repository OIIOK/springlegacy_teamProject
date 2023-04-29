package com.friendly.eco.model.community;

import java.util.List;
import com.friendly.eco.domain.SharingApplicant;

public interface SharingApplicantService {	
	public List<SharingApplicant> selectBySharingPK(int sharing_idx); //신청자
	public int selectCount(int sharing_idx); //신청자 수
	public SharingApplicant selectByWin(int applicant_win); //당첨자
	public void insert(SharingApplicant sharingApplicant);
	public void deleteOne(int applicant_idx);
	public void deleteBySharingPK(int sharing_idx);
	
}
