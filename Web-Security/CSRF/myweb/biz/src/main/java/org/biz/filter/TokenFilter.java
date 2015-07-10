package org.biz.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenFilter implements Filter {

    public TokenFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String servletPath = request.getServletPath();
		if(servletPath.equals("/error.html")){
			arg2.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().equals("/index.jsp") || request.getServletPath().equals("/token.jsp")){
			Object token = request.getSession().getAttribute("token");
			if(token==null){
				String tokenStr = UUID.randomUUID().toString();
				request.getSession().setAttribute("token", tokenStr);
				Cookie cookie = new Cookie("XSRF-TOKEN",tokenStr);
				response.addCookie(cookie);
			}
			arg2.doFilter(request, response);
			return;
		}else{
			Object token = request.getSession().getAttribute("token");
			System.out.println(request.getHeader("X-XSRF-TOKEN"));
			if(token==null){
				String path = request.getContextPath(); 
				String preUrl = path + "/error.html";
				response.sendRedirect(preUrl);
				return;
			}
		}
		
		arg2.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
