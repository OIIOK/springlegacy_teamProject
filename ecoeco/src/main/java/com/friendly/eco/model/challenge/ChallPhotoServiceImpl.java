package com.friendly.eco.model.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.ChallPhoto;

@Service
public class ChallPhotoServiceImpl implements ChallPhotoService{
	
	@Autowired
	private ChallPhotoDAO challPhotoDAO;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return challPhotoDAO.selectAll();
	}

	@Override
	public ChallPhoto select(int chall_photo_idx) {
		// TODO Auto-generated method stub
		return challPhotoDAO.select(chall_photo_idx);
	}
	@Override
	public List selectByChallenger(int challenger_idx) {
	
		return challPhotoDAO.selectByChallenger(challenger_idx);
	}
}
