package com.hsx.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.hsx.domain.User;
import com.hsx.exception.UserExistsException;
import com.hsx.service.UserService;
import com.hsx.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	private UserService userService = new UserServiceImpl();

	//@Test(expected=com.hsx.exception.UserExistsException.class)
	//@Test
	public void testRegister() throws UserExistsException {
		User user = new User();
		/*user.setId("002");
		user.setUsername("hsx");
		user.setPassword("hsx");
		user.setEmail("hsx@126.com");
		user.setBirthday(new Date());*/
		user.setId("003");
		user.setUsername("hsx2");
		user.setPassword("hsx2");
		user.setEmail("hsx2@126.com");
		user.setBirthday(new Date());
		userService.register(user);
	}

	@Test
	public void testLogin() {
		User user = userService.login("hsx2", "hsx2");
		Assert.assertNotNull(user);
	}

}
