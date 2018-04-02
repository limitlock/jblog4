package com.cafe24.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	public List<BlogVo> getList(String id) {
		return sqlSession.selectList("blog.getList", id);
	}

	public boolean update(String title, String url, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("logo", url);
		map.put("id", id);
		
		int count = sqlSession.update("blog.update", map);
		return count == 1;

	}

	public List<CategoryVo> getCategoryList(String id) {
		
		return sqlSession.selectList("blog.getCategoryList",id);
	}

	public List<PostVo> getPostList(String id, String no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("no", no);
		return sqlSession.selectList("blog.getPostList",map);
	}

	public List<PostVo> getPost(String id, String no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("no", no);
		return sqlSession.selectList("blog.C_getPost",map);
	}

	public List<PostVo> getPostOne(String id, String no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("no", no);
		
		return sqlSession.selectList("blog.P_getPostOne",map);
	}

	public List<PostVo> getPostMain(String id) {
		
		return sqlSession.selectList("blog.M_getPost",id);
	}

}
