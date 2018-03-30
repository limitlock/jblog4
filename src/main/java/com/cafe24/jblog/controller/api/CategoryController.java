package com.cafe24.jblog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.dto.JSONResult;
import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.security.Auth;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;

	@Auth
	@RequestMapping(value = "/{id}/admin/category", method = RequestMethod.GET)
	public String list(@PathVariable("id") String id) {

		return "blog/blog-admin-category";
	}

	@ResponseBody
	@RequestMapping(value = "/{id}/admin/categoryAjax", method = RequestMethod.GET)
	public JSONResult list2(@PathVariable("id") String id) {
		List<CategoryVo> list = categoryDao.getList(id);
		return JSONResult.success(list);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}/admin/category/category_write", method = RequestMethod.POST)
	public JSONResult join(@PathVariable("id") String id, @RequestParam("name") String name,
			@RequestParam("content") String content) {
		int count = categoryDao.insert(id, name, content);

		return JSONResult.success(count == 1 ? "true" : "false");
	}

	@ResponseBody
	@RequestMapping(value = "/{id}/admin/category/del", method = RequestMethod.POST)
	public JSONResult del(@PathVariable("id") String id, @RequestParam("categoryNo") Long no) {
		System.out.println(no);
		int count = categoryDao.delete(no);

		return JSONResult.success(count == 1 ? "true" : "false");
	}

}
