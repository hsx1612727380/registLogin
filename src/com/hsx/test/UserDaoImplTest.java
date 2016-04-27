package com.hsx.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.hsx.dao.UserDao;
import com.hsx.dao.impl.UserDaoImpl;
import com.hsx.domain.User;

public class UserDaoImplTest {
	
	private UserDao userDao = new UserDaoImpl();

	@Test
	public void testAddUser() {
		User user = new User();
		user.setId("002");
		user.setUsername("hsx");
		user.setPassword("hsx");
		user.setEmail("hsx@126.com");
		user.setBirthday(new Date());
		userDao.addUser(user);
	}

	public void testFindUserByUsername() {
		User user = userDao.findUserByUsername("hsx");
		User user2 = userDao.findUserByUsername("hsx1");
		Assert.assertNotNull(user);
		Assert.assertNull(user2);
	}

	public void testFindUserByUsernameAndPassword() {
		User user = userDao.findUserByUsernameAndPassword("hsx", "hsx");
		User user2 = userDao.findUserByUsernameAndPassword("hsx2", "hsx");
		Assert.assertNotNull(user);
		Assert.assertNull(user2);
	}

}
