package springWebmvc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class HttpServletBean extends HttpServlet {

	
	
	
	
	@Override
	public void init() throws ServletException {

		
		//���ServletConfig�Ļ�ȡ���������webapplication�ĳ�ʼ��
		
		getServletConfig();
	//	System.out.println(this.getInitParameter("contextConfigLocation"));
		//System.out.println("111sdjfldjf"+ getServletConfig().getInitParameter("contextConfigLocation"));
		
		initServletBean();
		
		
	}

	
	
	protected void initServletBean(){
		
	}
	
	
	
}
