package com.cafe24.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.security.Auth;

@Controller
public class BlogController {
	// {id:(?!assets).*}
	@Autowired
	private BlogService blogService;

	@RequestMapping("/{id}")
	public String main(@PathVariable("id") String id, Model model) {
		blogService.main(model, id);
		return "blog/blog-main";
	}

	@Auth(role = Auth.Role.ADMIN)
	@RequestMapping(value = "/{id}/admin/basic", method = RequestMethod.GET)
	public String adminBasic(@PathVariable("id") String id, Model model) { // @PathVariable Optional<Long> no 있을 수도 있고
																			// 없을 수도 있겠끔 설정
		blogService.main(model, id);
		return "blog/blog-admin-basic";
	}

	@RequestMapping(value = "/{id}/admin/basic", method = RequestMethod.POST)
	public String adminBasic(@PathVariable("id") String id, @RequestParam("title") String title,
			@RequestParam("logo") MultipartFile multipartFile) {
		String url = blogService.restore(multipartFile);
		blogService.modify(title, url, id);
		return "redirect:/" + id;
	}

	@RequestMapping("/{id}/view/{categoryNo}/{postNo}")
	public String postView(@PathVariable("id") String id, Model model, @PathVariable("postNo") String no,
			@PathVariable("categoryNo") String categoryno) {
		blogService.postView(model, id, no, categoryno);
		return "blog/blog-main";
	}

	@RequestMapping("/{id}/listview/{categoryNo}")
	public String postlistView(@PathVariable("id") String id, Model model, @PathVariable("categoryNo") String no) {
		blogService.postlistView(model, id, no);
		return "blog/blog-main";
	}

}
