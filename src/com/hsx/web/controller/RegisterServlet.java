package com.hsx.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.hsx.domain.User;
import com.hsx.exception.UserExistsException;
import com.hsx.service.UserService;
import com.hsx.service.impl.UserServiceImpl;
import com.hsx.util.FillFormBean;
import com.hsx.web.formbean.UserRegisterFormBean;

public class RegisterServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 验证用户输入[把请求中的数据封装到一个FormBean中]
		UserRegisterFormBean userRegisterFormBean = FillFormBean.toFormBean(request, UserRegisterFormBean.class);
		// 当验证不通过时，跳转到输入页面，回显用户原来写的数据
		if (!userRegisterFormBean.validateRegister()) {
			request.setAttribute("userRegisterFormBean", userRegisterFormBean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}
		try {
			// 当验证通过时，把数据填到User模型中
			User user = new User();
			ConvertUtils.register(new DateLocaleConverter(), Date.class); // 注册一个类型转换器，完成String类型的birthday到Date类型的birthday
			BeanUtils.copyProperties(user, userRegisterFormBean); //把userRegisterFormBean中的数据传入到user中，注意：只能作用于基本数据类型和String类型
			// 转换有错，给出提示，转向一个全局的消息页面
			userService.register(user);
			request.setAttribute("message", "注册成功，3秒后转向主页！<meta http-equiv='Refresh' content='3;URL="+ request.getContextPath() +"/index.jsp'>");
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
		} catch (UserExistsException e) {
			// 用户存在：UserExistsException回显数据，并提示用户的用户名已经存在
			userRegisterFormBean.getErrors().put("username", "用户名已经存在");
			request.setAttribute("userRegisterFormBean", userRegisterFormBean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "注册失败！");
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
