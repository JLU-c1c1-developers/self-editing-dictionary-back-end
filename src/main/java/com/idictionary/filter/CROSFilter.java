package com.idictionary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="CROSFilter",urlPatterns= {"*"})
public class CROSFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println("�������������ص�����" + req.getRequestURI());
		rep.setHeader("Access-Control-Allow-Origin", req.getHeader("origin"));
		rep.setHeader("Access-Control-Allow-Credentials", "true");
		rep.setHeader("Access-Control-Allow-Headers", "Authorization");
		
		if("OPTIONS".equals(req.getMethod())) {
			System.out.println("���ص�Ԥ������");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
