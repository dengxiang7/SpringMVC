package springWebmvc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class HttpServletBean extends HttpServlet {

	
	
	
	
	@Override
	public void init() throws ServletException {

		
		//完成ServletConfig的获取，用以完成webapplication的初始化
		
		getServletConfig();
	//	System.out.println(this.getInitParameter("contextConfigLocation"));
		//System.out.println("111sdjfldjf"+ getServletConfig().getInitParameter("contextConfigLocation"));
		
		initServletBean();
		
		
	}

	
	
	protected void initServletBean(){
		
	}
	
	
	
}
