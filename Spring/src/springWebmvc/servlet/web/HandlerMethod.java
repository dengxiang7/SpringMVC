package springWebmvc.servlet.web;

import java.lang.reflect.Method;



import SpringFrameWork.Bean.Factory.BeanFactory;



public class HandlerMethod {

	//method 所在的类Handler。
	private final Object bean;
	
	private final BeanFactory beanFactory;
	
	private final Method method;
	
	//private final MethodParameter[] parameters;
	
	private final HandlerMethod handlerMethod;
	
	
	public HandlerMethod(Object bean ,Method method)
	{
		this.bean=bean;
		this.method=method;
		this.beanFactory=null;
		this.handlerMethod=null;
	}


	public Object getBean() {
		return bean;
	}


	public BeanFactory getBeanFactory() {
		return beanFactory;
	}


	public Method getMethod() {
		return method;
	}


	public HandlerMethod getHandlerMethod() {
		return handlerMethod;
	}


	

	
	
}
