package com.friendly.eco.model.challenge;

import java.util.List;

import com.friendly.eco.domain.ChallPhoto;

public interface ChallPhotoDAO {
	public List selectAll();
	public ChallPhoto select(int chall_photo_idx);
	public List selectByChallenger(int challenger_idx);
	
}
