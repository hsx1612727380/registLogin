package com.hsx.service;

import com.hsx.domain.User;
import com.hsx.exception.UserExistsException;

public interface UserService {

	/**
	 * 用户注册
	 * [若用户名已经存在，则抛出一个异常(UserExistsException)]
	 * [注册时需要对用户密码加密]
	 * @param user
	 */
	public void register(User user) throws UserExistsException;
	
	/**
	 * 用户登录
	 * [用户输入的密码需要加密]
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
	
}