package com.friendly.eco.model.community;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.friendly.eco.domain.ChatterComments;
import com.friendly.eco.exception.ChatterCommentsException;

@Repository
public class MybatisChatterCommentsDAO implements ChatterCommentsDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ChatterComments> selectByChatterPK(int chatter_idx) {
		return sqlSessionTemplate.selectList("ChatterComments.selectByChatterPK", chatter_idx);
	}

	@Override
	public int selectCount(int chatter_idx) {
		return sqlSessionTemplate.selectOne("ChatterComments.selectCount", chatter_idx);
	}

	@Override
	public void insert(ChatterComments chatterComments) throws ChatterCommentsException {
		int result = sqlSessionTemplate.insert("ChatterComments.insert", chatterComments);

		if (result < 1) { // 실패일 경우
			throw new ChatterCommentsException("수다댓글 등록 실패");
		}
	}

	@Override
	public void update(ChatterComments chatterComments) throws ChatterCommentsException {
		int result = sqlSessionTemplate.update("ChatterComments.update", chatterComments);

		if (result < 1) { // 실패일 경우
			throw new ChatterCommentsException("수다댓글 수정 실패");
		}
	}

	@Override
	public void deleteOne(int chattercomments_idx) throws ChatterCommentsException {
		int result = sqlSessionTemplate.delete("ChatterComments.deleteOne", chattercomments_idx);

		if (result < 1) { // 실패일 경우
			throw new ChatterCommentsException("수다댓글 한건 삭제 실패");
		}
	}

	@Override
	public void deleteByChatterPK(int chatter_idx) throws ChatterCommentsException {
		int result = sqlSessionTemplate.delete("ChatterComments.deleteByChatterPK", chatter_idx);

		if (result < 1) { // 실패일 경우
			throw new ChatterCommentsException("수다댓글 목록 삭제 실패");
		}
	}
}
