package com.cafe24.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getList(String id) {
		return sqlSession.selectList("category.getList", id);

	}

	public int insert(String id, String name, String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("content", content);

		return sqlSession.insert("category.insert", map);
	}

	public int delete(Long no) {
		return sqlSession.delete("category.delete", no);
	}

}
