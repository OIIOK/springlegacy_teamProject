package com.friendly.eco.model.mem;


import java.util.List;

import com.friendly.eco.domain.Mem;

public interface MemService {
	public Mem selectById(Mem mem); 
	public Mem login(Mem mem); //로그인 시 사용(1)
	public List selectAll();
	public Mem selectByIdx(Mem mem); //구글 로그인에 사용
	public Mem select(String mem_id); //로그인 시 사용(2)
	public void regist(Mem mem); //암호화, 이메일, db값 저장
	public void insertBysns(Mem mem); //sns로그인 
	public void update(Mem mem);
	public void unregist(int mem_idx); //이메일
}
