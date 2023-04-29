package com.friendly.eco.model.community;

import java.util.List;
import com.friendly.eco.domain.SharingCategory;

public interface SharingCategoryService {
	public List<SharingCategory> selectAll();
	public SharingCategory selectByPK(int sharingcategory_idx);
}
