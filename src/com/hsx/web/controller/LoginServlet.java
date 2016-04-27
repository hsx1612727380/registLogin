package com.hsx.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hsx.domain.User;
import com.hsx.service.UserService;
import com.hsx.service.impl.UserServiceImpl;
import com.hsx.util.FillFormBean;
import com.hsx.util.MyConstant;
import com.hsx.web.formbean.UserLoginFormBean;

public class LoginServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserLoginFormBean userLoginFormBean = FillFormBean.toFormBean(request, UserLoginFormBean.class);
		// 根据用户名个密码检测是否存在
		try {
			User user = new User();
			BeanUtils.copyProperties(user, userLoginFormBean);
			User u = userService.login(user.getUsername(), user.getPassword());
			if (u == null) { //用户不存在
				request.setAttribute("message", "用户名或者密码不正确");
				request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
				return;
			}
			// 用户存在,把用户存放发哦session中
			HttpSession session = request.getSession();
			session.setAttribute(MyConstant.LOGIN_USER, u);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "登录失败！");
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
