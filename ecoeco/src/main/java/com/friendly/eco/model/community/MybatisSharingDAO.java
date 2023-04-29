package com.friendly.eco.model.community;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.Sharing;
import com.friendly.eco.exception.SharingException;

@Repository
public class MybatisSharingDAO implements SharingDAO {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Sharing> selectAll() {
		return sqlSessionTemplate.selectList("Sharing.selectAll");
	}

	@Override
	public List<Sharing> selectBySCategoryPK(int sharingcategory_idx) {
		return sqlSessionTemplate.selectList("Sharing.selectBySCategoryPK", sharingcategory_idx);
	}

	@Override
	public Sharing selectByPK(int sharing_idx) {
		return sqlSessionTemplate.selectOne("Sharing.selectByPK", sharing_idx);
	}

	@Override
	public void insert(Sharing sharing) throws SharingException {

		logger.info("categoryname : " + sharing.getSharingCategory().getSharingcategory_categoryname()); //name 안에 null
		logger.info("caringcategory_idx : " + sharing.getSharingCategory().getSharingcategory_idx());

		int result = sqlSessionTemplate.insert("Sharing.insert", sharing);
		if (result < 1) {
			throw new SharingException("나눔글 등록 실패");
		}
	}

	@Override
	public void update(Sharing sharing) throws SharingException {
		int result = sqlSessionTemplate.update("Sharing.update", sharing);

		if (result < 1) {
			throw new SharingException("나눔글 수정 실패");
		}
	}
	
	@Override
	public void updateIndex(Sharing sharing) throws SharingException {
		int result = sqlSessionTemplate.update("Sharing.updateIndex", sharing); //문제있대


		if (result < 1) {
			throw new SharingException("나눔글 인덱스 수정 실패");
		}
	}

	@Override
	public void delete(int sharing_idx) throws SharingException {
		
		int result = sqlSessionTemplate.delete("Sharing.delete", sharing_idx);

		if (result < 1) {
			throw new SharingException("나눔글 삭제 실패");
		}
	}


}
