package com.friendly.eco.model.community;

import java.util.List;
import com.friendly.eco.domain.Chatter;

public interface ChatterService {

	public List<Chatter> selectAll();
	public Chatter selectByPK(int chatter_idx);
	public void upgInsert(Chatter chatter, String dir); // 섬네일 저장 기능 추가 (dir = 주소)
	public void update(Chatter chatter); // 섬네일 수정 기능 추가 (dir = 주소)
	public void upgUpdate(Chatter chatter, String dir); // 섬네일 수정 기능 추가 (dir = 주소)
	public void delete(int chatter_idx); 
}