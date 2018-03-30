package com.cafe24.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Service
public class BlogService {

	private String SAVE_PATH = "/uploads";
	private String PREFIX_URL = "/uploads/";

	@Autowired
	private BlogDao blogDao;

	public void main(Model model, String id) {
		List<BlogVo> list = blogDao.getList(id);
		model.addAttribute("list", list);

		List<CategoryVo> categoryList = blogDao.getCategoryList(id);
		model.addAttribute("categoryList", categoryList);
		
		List<PostVo> postList = blogDao.getPostList(id,"1");
		model.addAttribute("postList",postList);
		
		List<PostVo> post = blogDao.getPost(id);
		model.addAttribute("post",post);
		
		model.addAttribute("id",id);
		System.out.println("main()");
	}

	public void modify(String title, String url, String id) {

		blogDao.update(title, url, id);

	}

	public String restore(MultipartFile multipartFile) {

		String url = "";

		try {

			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());

			Long size = multipartFile.getSize();

			String saveFilename = genSaveFilename(extName);

			System.out.println("##########" + originFilename);
			System.out.println("##########" + extName);
			System.out.println("##########" + size);
			System.out.println("##########" + saveFilename);

			writeFiel(multipartFile, saveFilename);
			url = PREFIX_URL + saveFilename;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return url;
	}

	private void writeFiel(MultipartFile multipartFile, String saveFilename) throws IOException {
		byte[] filedata = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(filedata);
		fos.flush();
		fos.close();
	}

	private String genSaveFilename(String extName) {

		String filename = "";

		Calendar cl = Calendar.getInstance();
		filename += cl.get(Calendar.YEAR);
		filename += cl.get(Calendar.MONTH);
		filename += cl.get(Calendar.DATE);
		filename += cl.get(Calendar.HOUR);
		filename += cl.get(Calendar.MINUTE);
		filename += cl.get(Calendar.SECOND);
		filename += cl.get(Calendar.MILLISECOND);
		filename += extName;

		return filename;
	}

	public void postView(Model model, String id, String no, String categoryno) {
		List<BlogVo> list = blogDao.getList(id);
		model.addAttribute("list", list);

		List<CategoryVo> categoryList = blogDao.getCategoryList(id);
		model.addAttribute("categoryList", categoryList);
		
		List<PostVo> postList = blogDao.getPostList(id,categoryno);
		model.addAttribute("postList",postList);
		List<PostVo> post = blogDao.getPostOne(id,no);
		model.addAttribute("post",post);
		
	}

	public void postlistView(Model model, String id, String no) {
		List<BlogVo> list = blogDao.getList(id);
		model.addAttribute("list", list);

		List<CategoryVo> categoryList = blogDao.getCategoryList(id);
		model.addAttribute("categoryList", categoryList);
		
		List<PostVo> postList = blogDao.getPostList(id, no);
		model.addAttribute("postList",postList);
		
		List<PostVo> post = blogDao.getPost(id);
		model.addAttribute("post",post);
		
	}

}
