package com.friendly.eco.model.donation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendly.eco.domain.Dpostscript;
import com.friendly.eco.exception.DpostscriptException;

@Repository
public class MybatisDpostscriptDAO implements DpostscriptDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List selectAll() {
		return sqlSessionTemplate.selectList("Dpostscript.selectAll");
	}

	public Dpostscript select(int dpostscript_idx) {
		return sqlSessionTemplate.selectOne("Dpostscript.select", dpostscript_idx);
	}

	public void insert(Dpostscript dpostscript) throws DpostscriptException{
		int result=sqlSessionTemplate.insert("Dpostscript.insert", dpostscript);
		if(result<1) {
			throw new DpostscriptException("기부후기 등록 실패");
		}
	}

	public void update(Dpostscript dpostscript) throws DpostscriptException{
		int result=sqlSessionTemplate.update("Dpostscript.update", dpostscript);
		if(result<1) {
			throw new DpostscriptException("기부후기 수정 실패");
		}
	}

	public void delete(int dpostscript_idx) throws DpostscriptException{
		int result=sqlSessionTemplate.delete("Dpostscript.delete", dpostscript_idx);
		if(result<1) {
			throw new DpostscriptException("기부후기 삭제 실패");
		}
	}
	
}
