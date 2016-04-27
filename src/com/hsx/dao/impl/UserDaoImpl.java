package com.hsx.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import com.hsx.dao.UserDao;
import com.hsx.domain.User;
import com.hsx.exception.UserDaoException;
import com.hsx.util.XmlUtil;

public class UserDaoImpl implements UserDao {

	@SuppressWarnings("deprecation")
	@Override
	public void addUser(User user) {
		try {
			Document document = XmlUtil.getDocument();
			Element root = document.getRootElement();
			root.addElement("user")
				.addAttribute("id", user.getId())
				.addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", user.getBirthday().toLocaleString());
			XmlUtil.write2xml(document);
		} catch (Exception e) {
			throw new UserDaoException(e);
		}
	}

	@Override
	public User findUserByUsername(String username) {
		try {
			String xPath = "//user[@username='"+ username +"']";
			Document document = XmlUtil.getDocument();
			Element element = (Element) document.selectSingleNode(xPath);
			if (element == null) {
				return null;
			}
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setUsername(username);
			user.setPassword(element.attributeValue("password"));
			user.setEmail(element.attributeValue("email"));
			String birthdayString = element.attributeValue("birthday");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(dateFormat.parse(birthdayString));
			return user;
		} catch (Exception e) {
			throw new UserDaoException(e);
		}
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		try {
			String xPath = "//user[@username='"+ username +"' and @password='"+ password +"']";
			Document document = XmlUtil.getDocument();
			Element element = (Element) document.selectSingleNode(xPath);
			if (element == null) {
				return null;
			}
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(element.attributeValue("email"));
			String birthdayString = element.attributeValue("birthday");
			DateFormat dateFormat =	new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(dateFormat.parse(birthdayString));
			return user;
		} catch (Exception e) {
			throw new UserDaoException(e);
		}
	}
	
}
