package xianming.shop.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import xianming.shop.model.SystemContext;
import xianming.shop.model.User;

public class SystemContextFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest hrequest = (HttpServletRequest)request;
			User u = (User)hrequest.getSession().getAttribute("loginUser");
			if(u!=null) SystemContext.setLoginUser(u);
			chain.doFilter(request, response);
		} finally {
			SystemContext.removeLoginUser();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
