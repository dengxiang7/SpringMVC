package springWebmvc.servlet;

import javax.servlet.http.HttpServletRequest;

import springWebmvc.servlet.web.HandlerMethod;


public interface HandlerMapping {
	
	
	
	HandlerMethod getHandler(HttpServletRequest request);

}
