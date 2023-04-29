package com.friendly.eco.model.community;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.friendly.eco.domain.SharingApplicant;
import com.friendly.eco.exception.SharingApplicantException;

@Repository
public class MybatisSharingApplicantDAO implements SharingApplicantDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<SharingApplicant> selectBySharingPK(int sharing_idx) {
		return sqlSessionTemplate.selectList("SharingApplicant.selectBySharingPK", sharing_idx);
	}

	@Override
	public int selectCount(int sharing_idx) {
		return sqlSessionTemplate.selectOne("SharingApplicant.selectCount", sharing_idx);
	}

	@Override
	public SharingApplicant selectByWin(int applicant_win) {
		return sqlSessionTemplate.selectOne("SharingApplicant.selectByWin", applicant_win);
	}

	@Override
	public void insert(SharingApplicant sharingApplicant) throws SharingApplicantException {

		int result = sqlSessionTemplate.insert("SharingApplicant.insert", sharingApplicant);

		if (result < 1) {
			throw new SharingApplicantException("신청 실패");
		}
	}

	@Override
	public void deleteOne(int applicant_idx) throws SharingApplicantException {
		int result = sqlSessionTemplate.insert("SharingApplicant.deleteOne", applicant_idx);

		if (result < 1) {
			throw new SharingApplicantException("삭제 실패");
		}
	}

	@Override
	public void deleteBySharingPK(int sharing_idx) throws SharingApplicantException {
		int result = sqlSessionTemplate.insert("SharingApplicant.deleteBySharingPK", sharing_idx);

		if (result < 1) {
			throw new SharingApplicantException("삭제 실패");
		}
	}
}
