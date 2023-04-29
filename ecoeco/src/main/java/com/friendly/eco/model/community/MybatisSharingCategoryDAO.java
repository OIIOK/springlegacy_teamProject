package com.friendly.eco.model.community;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.friendly.eco.domain.SharingCategory;

@Repository
public class MybatisSharingCategoryDAO implements SharingCategoryDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<SharingCategory> selectAll() {
		return sqlSessionTemplate.selectList("SharingCategory.selectAll");
	}

	@Override
	public SharingCategory selectByPK(int sharingcategory_idx) {
		return sqlSessionTemplate.selectOne("SharingCategory.selectByPK");
	}
}
