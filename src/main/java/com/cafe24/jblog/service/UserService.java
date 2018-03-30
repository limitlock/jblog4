package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void join(UserVo vo) {
		userDao.insert(vo);
	}

	public void blogJoin(UserVo vo) {
		userDao.blogInsert(vo);
	}

	public UserVo getUser(UserVo vo) {
		return userDao.get(vo);
	}

}
