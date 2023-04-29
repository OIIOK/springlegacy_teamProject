package com.friendly.eco.model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.MemBirth;
import com.friendly.eco.domain.MemEmail;
import com.friendly.eco.domain.MemName;
import com.friendly.eco.domain.MemNickname;
import com.friendly.eco.domain.MemPass;
import com.friendly.eco.domain.MemPhone;

@Service
public class MemServiceImpl implements MemService{	
	@Autowired
	private MemDAO memDAO;
	@Autowired
	private MemTypeDAO memTypeDAO;
	@Autowired
	private MemPassDAO memPassDAO;
	@Autowired
	private MemNameDAO memNameDAO;
	@Autowired
	private MemBirthDAO memBirthDAO;
	@Autowired
	private MemPhoneDAO memPhoneDAO;
	@Autowired
	private MemEmailDAO memEmailDAO;
	@Autowired
	private MemNicknameDAO memNickNameDAO;
	
	
	@Override
	public List selectAll() {
		return memDAO.selectAll();
	}

	@Override
	public Mem select(String mem_id) { //login에서 사용
		return memDAO.select(mem_id);
	}

	@Override
	public void regist(Mem mem) {
		//암호화 
		//String hash=passConverter.convertHash(member.getPass());
		//member.setPass(hash); //DTO의 패스워드를 hash 값으로 대체
		
		//이메일
		//emailManager.send(member);
		
		//db저장
		memDAO.insert(mem); //정보가 자동 mapping됨
		System.out.println("service에서의 mem 초기 값 : " + mem); 
		
		//각각 다른 테이블에 db를 넣어주기에, idx값을 동일하게 해줘야 함! -> idx값을 구해오자
		int mem_idx = mem.getMem_idx();
		System.out.println("idx는 : " +  mem_idx);
		
		MemPass memPass = mem.getMemPass();
		System.out.println("memPass 값이 뭐지?" + memPass); //여기 값 다 넘어오는데? ㅎㅎ여기서 insert하면 되겠다.
		MemName memName = mem.getMemName();
		MemBirth memBirth = mem.getMemBirth();
		MemPhone memPhone = mem.getMemPhone();
		MemEmail memEmail = mem.getMemEmail();
		MemNickname memNickname = mem.getMemNickname();
		
		memPass.setMem_idx(mem_idx); //idx값 삽입!
		memPassDAO.insert(memPass);
		//memName.getMem().setMem_idx(mem_idx); //이 코드가 안 돼서 그냥 Mem mem -> int mem_idx로 변경함
		memName.setMem_idx(mem_idx);
		memNameDAO.insert(memName);
		memBirth.setMem_idx(mem_idx);
		memBirthDAO.insert(memBirth);
		memPhone.setMem_idx(mem_idx);
		memPhoneDAO.insert(memPhone);
		memEmail.setMem_idx(mem_idx);
		memEmailDAO.insert(memEmail);
		memNickname.setMem_idx(mem_idx);
		memNickNameDAO.insert(memNickname);
	}

	@Override
	public void update(Mem mem) {
		memDAO.update(mem);
	}

	@Override
	public void unregist(int mem_idx) {
		memDAO.delete(mem_idx);
	}

	@Override
	public Mem login(Mem mem) {
		return memDAO.login(mem);
	}

	@Override
	public Mem selectById(Mem mem) {
		return memDAO.selectById(mem);
	}

	@Override
	public void insertBysns(Mem mem) {
		System.out.println("serviceImpl : sns mem : " + mem);
		memDAO.insertBysns(mem);
	}

	@Override
	public Mem selectByIdx(Mem mem) {
		return memDAO.selectByIdx(mem);
	}


}
