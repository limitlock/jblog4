package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.jblog.repository.PostDao;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;

	public void categoryCombox(String id, Model model) {
		
		List<CategoryVo> categoryList = postDao.getCategoryList(id);
		model.addAttribute("categoryList", categoryList);
		
	}

	public void postWrite(PostVo vo) {
		postDao.insert(vo);
		
	}

}
