package com.hsx.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * FormBean：与用户的输入对应 验证用户的输入
 * 
 * @author hsx
 * 
 */
public class UserRegisterFormBean {

	private String username;
	private String password;
	private String rePassword;
	private String birthday;
	private String email;
	private Map<String, String> errors = new HashMap<String, String>(); //封装错误信息[key=输入域的名称，value=错误消息]
								
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 验证用户输入
	 * @return
	 */
	public boolean validateRegister() {
		boolean isOk = true;
		
		/**
		 * username：不能为空，且必须是3~8位字母或数字
		 * password：不能为空，且必须是6~18位字母或数字
		 * rePassword：必须与password一致
		 * birthday：必须是一个日期类型
		 * email：必须符合email的书写规范
		 */

		if (username == null || username.trim().equals("")) {
			isOk = false;
			errors.put("username", "用户名不能为空");
		}
		else {
			if (!username.matches("[a-zA-Z0-9]{3,8}")) {
				isOk = false;
				errors.put("username", "用户名必须是3~8位字母或数字组成");
			}
		}
			
		if (password == null || password.trim().equals("")) {
			isOk = false;
			errors.put("password", "密码不能为空");
		}
		else {
			if (!password.matches("[a-zA-Z0-9]{6,8}")) {
				isOk = false;
				errors.put("password", "用户名必须是6~18位字母或数字组成");
			}
		}
		
		if (!password.equals(rePassword)) {
			isOk = false;
			errors.put("rePassword", "两次输入的密码不一致");
		}
		
		if (birthday != null) {
			try {
				DateLocaleConverter dateLocaleConverter = new DateLocaleConverter("yyyy-MM-dd");
				dateLocaleConverter.convert(birthday);
			} catch (Exception e) {
				isOk = false;
				errors.put("birthday", "请输入正确的日期");
			}
		}
		
		if (email != null) {
			if (!email.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
				isOk = false;
				errors.put("email", "必须符合邮箱的书写规范");
			}
		}
		
		return isOk;
	}

}
