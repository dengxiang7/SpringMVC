package SpringFrameWork.web;

import javax.servlet.ServletContext;

import SpringFrameWork.Context.ApplicationContext;

public interface WebApplicationContext extends ApplicationContext {

	
	ServletContext getServletContext();

	
}
