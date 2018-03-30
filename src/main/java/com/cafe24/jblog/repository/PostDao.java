package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getCategoryList(String id) {
	
		return sqlSession.selectList("blog.getCategoryList",id);
	}

	public boolean insert(PostVo vo) {

		int count = sqlSession.insert("post.insert", vo);

		return count == 1;
		
	}

}
