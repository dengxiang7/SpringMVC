package SpringFrameWork.web.support;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import SpringFrameWork.Context.support.AbstractRefreshableApplicationContext;
import SpringFrameWork.web.WebApplicationContext;



public abstract class AbstractRefreshableWebApplicationContext extends
		AbstractRefreshableApplicationContext  implements WebApplicationContext{

	
	
	private ServletContext servletContext;
	private ServletConfig  servletConfig;
	
	
	
	
	@Override
	public ServletContext getServletContext() {
		return this.servletContext;
	}




	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}




	public ServletConfig getServletConfig() {
		return servletConfig;
	}




	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;
	}

	

}
