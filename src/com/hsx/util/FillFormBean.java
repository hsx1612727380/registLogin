package com.hsx.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 把请求中的数据填充到FormBean中
 * @author hsx
 *
 */
public class FillFormBean {

	public static <T> T toFormBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			Map params = request.getParameterMap();
			BeanUtils.populate(bean, params); //相当于setXxx()方法
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
