package com.hsx.service.impl;

import com.hsx.dao.UserDao;
import com.hsx.dao.impl.UserDaoImpl;
import com.hsx.domain.User;
import com.hsx.exception.UserExistsException;
import com.hsx.service.UserService;
import com.hsx.util.MD5Util;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void register(User user) throws UserExistsException {
		// 判断用户是否存在
		User u = userDao.findUserByUsername(user.getUsername());
		if (u != null) {
			throw new UserExistsException("用户已经存在");
		}
		// 用户不存在进行注册
		user.setPassword(MD5Util.encode(user.getPassword()));
		userDao.addUser(user);
	}

	@Override
	public User login(String username, String password) {
		
		return userDao.findUserByUsernameAndPassword(username, MD5Util.encode(password));
	}

}
