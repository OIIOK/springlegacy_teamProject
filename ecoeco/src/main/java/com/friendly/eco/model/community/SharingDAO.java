package com.friendly.eco.model.community;

import java.util.List;
import com.friendly.eco.domain.Sharing;

public interface SharingDAO {

	public List<Sharing> selectAll();
	public List<Sharing> selectBySCategoryPK(int sharingcategory_idx);
	public Sharing selectByPK(int sharing_idx);
	public void insert(Sharing sharing);
	public void update(Sharing sharing);
	public void updateIndex(Sharing sharing);
	public void delete(int sharing_idx);
}
