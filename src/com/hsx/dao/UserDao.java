package com.hsx.dao;

import com.hsx.domain.User;

public interface UserDao {
	
	/**
	 * 将用户添加在xml中[register]
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 根据用户名查询用户[当注册时，判断这个用户名是否可用]
	 * @param username
	 * @return 查到返回User对象，没有查到返回null
	 */
	public User findUserByUsername(String username);

	/**
	 * 根据用户名和密码查询用户[当登录时，判断用户是否存在xml中]
	 * @param username
	 * @param password
	 * @return 查到返回User对象，没有查到返回null
	 */
	public User findUserByUsernameAndPassword(String username, String password);
	
	
}
