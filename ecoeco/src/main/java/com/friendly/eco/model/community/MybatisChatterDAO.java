package com.friendly.eco.model.community;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.friendly.eco.domain.Chatter;
import com.friendly.eco.exception.ChatterException;

@Repository
public class MybatisChatterDAO implements ChatterDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Chatter> selectAll() {
		return sqlSessionTemplate.selectList("Chatter.selectAll");
	}

	@Override
	public Chatter selectByPK(int chatter_idx) {
		return sqlSessionTemplate.selectOne("Chatter.selectByPK", chatter_idx);
	}

	@Override
	public void insert(Chatter chatter) throws ChatterException {
		int result = sqlSessionTemplate.insert("Chatter.insert", chatter); // 성공한 레코드 수가 int로 반환됨

		if (result < 1) { // 실패일 경우
			throw new ChatterException("수다글 등록 실패");
		}
	}

	@Override
	public void update(Chatter chatter) throws ChatterException {
		int result = sqlSessionTemplate.update("Chatter.update", chatter);

		if (result < 1) {
			throw new ChatterException("수다글 수정 실패");
		}
	}

	@Override
	public void delete(int chatter_idx) throws ChatterException {
		int result = sqlSessionTemplate.delete("Chatter.delete", chatter_idx);

		if (result < 1) {
			throw new ChatterException("수다글 삭제 실패");
		}
	}
}
