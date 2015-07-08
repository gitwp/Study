package crsf.normal.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crsf.normal.web.bean.User;

public class SessionFilter implements Filter {

    public SessionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String servletPath = request.getServletPath();
		String forwardUrl = "/login.jsp";
		// 如果请求的路径与forwardUrl相同，或请求的路径是排除的URL时，则直接放行
		if(servletPath.equals(forwardUrl) || servletPath.equals("/login") ){
			arg2.doFilter(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		Object o = session.getAttribute("user");
		
		if(o==null){
			String path = request.getContextPath(); 
			String preUrl = path + "/login.jsp";
			response.sendRedirect(preUrl);
			return;
		}else{
			arg2.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
