package springWebmvc.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.student;
import SpringFrameWork.Context.ApplicationContext;
import SpringFrameWork.web.support.XmlWebApplicationContext;

public class FrameworkServlet extends HttpServletBean {

	private  XmlWebApplicationContext  webApplicationContext;
	
	
	@Override
	protected void initServletBean() {


		this.webApplicationContext=initWebApplicationContext();
		
		
		
		onRefresh(webApplicationContext);
	}

	
	protected XmlWebApplicationContext initWebApplicationContext()
	{
		
		this.webApplicationContext=createWebApplicationContext(getServletContext());
		
		
		
		return this.webApplicationContext;
	}
	
	
	
	protected XmlWebApplicationContext createWebApplicationContext(ServletContext servletContext)
	{
		
		this.webApplicationContext=new XmlWebApplicationContext();
		
		this.webApplicationContext.setServletContext(servletContext);
		
		this.webApplicationContext.setLocation(getServletConfig().getInitParameter("contextConfigLocation"));
		
		this.webApplicationContext.refresh();
		return this.webApplicationContext;
	}
	
	
	
	protected void onRefresh (ApplicationContext ac)
	{
		
	}


	
	
	@Override
	protected final void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.service(req, resp);
	}


	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}


	@Override
	protected final void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}


	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}


	@Override
	protected final void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}


	@Override
	protected final void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}


	@Override
	protected final void doOptions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req,resp);
	}


	@Override
	protected final void doTrace(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		processRequest(req,resp);
	}
	
	
	
	protected final void processRequest(HttpServletRequest req, HttpServletResponse resp)
	{
		
		
		
		doService(req,resp);
		
	}
	
	
	
	
	protected void doService(HttpServletRequest req, HttpServletResponse resp)
	{
		
	}
	
	
	
}
