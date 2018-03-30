package com.cafe24.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog.service.PostService;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.security.Auth;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@Auth(role = Auth.Role.ADMIN)
	@RequestMapping(value = "/{id}/admin/write", method = RequestMethod.GET)
	public String adminWrite(@PathVariable("id") String id, Model model) { // @PathVariable Optional<Long> no 있을 수도 있고
																			// 없을 수도 있겠끔 설정
		postService.categoryCombox(id,model);
		
		return "blog/blog-admin-write";
	}

	@RequestMapping(value = "/{id}/admin/write", method = RequestMethod.POST)
	public String adminWrite(@PathVariable("id") String id, @ModelAttribute PostVo vo) {

		postService.postWrite(vo);
		return "redirect:/" + id;
	}

}
