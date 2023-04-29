package com.friendly.eco.model.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.SharingCategory;

@Service
public class SharingCategoryServiceImpl implements SharingCategoryService{

	@Autowired
	SharingCategoryDAO sharingCategoryDAO;
	
	@Override
	public List<SharingCategory> selectAll() {
		return sharingCategoryDAO.selectAll();
	}

	@Override
	public SharingCategory selectByPK(int sharingcategory_idx) {
		return sharingCategoryDAO.selectByPK(sharingcategory_idx);
	}

}
