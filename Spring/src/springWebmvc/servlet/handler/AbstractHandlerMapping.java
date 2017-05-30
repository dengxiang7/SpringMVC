package springWebmvc.servlet.handler;

import javax.servlet.http.HttpServletRequest;

import SpringFrameWork.Bean.Factory.Support.DefaultListableBeanFactory;
import springWebmvc.servlet.HandlerMapping;
import springWebmvc.servlet.web.HandlerMethod;

public abstract class AbstractHandlerMapping implements HandlerMapping {

	
	private DefaultListableBeanFactory beanfactory=null;
	
	
	
	
	public DefaultListableBeanFactory getBeanfactory() {
		return beanfactory;
	}



	public void setBeanfactory(DefaultListableBeanFactory beanfactory) {
		this.beanfactory = beanfactory;
	}



	public HandlerMethod getHandler(HttpServletRequest request) {
		
		
		HandlerMethod  handler=getHandlerInternal(request);
		
		return handler;
	}

	
	
	protected abstract HandlerMethod getHandlerInternal(HttpServletRequest request);
	
}
