package com.friendly.eco.model.community;

import java.util.List;
import com.friendly.eco.domain.ChatterComments;

public interface ChatterCommentsService {

	public List<ChatterComments> selectByChatterPK(int chatter_idx);
	public int selectCount(int chatter_idx);
	public void insert(ChatterComments chatterComments);
	public void update(ChatterComments chatterComments);
	public void deleteOne(int chattercomments_idx);
	public void deleteByChatterPK(int chatter_idx);
}
