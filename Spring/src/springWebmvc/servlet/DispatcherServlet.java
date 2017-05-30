package springWebmvc.servlet;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import springWebmvc.servlet.mvc.method.annation.RequestMappingHandlerMapping;
import springWebmvc.servlet.web.HandlerMethod;
import test.student;
import SpringFrameWork.Bean.Factory.Support.DefaultListableBeanFactory;
import SpringFrameWork.Context.ApplicationContext;
import SpringFrameWork.web.support.XmlWebApplicationContext;


public class DispatcherServlet extends FrameworkServlet {

	private List<HandlerMapping> handlerMappings=new ArrayList<HandlerMapping>();
	
	
	@Override
	protected void onRefresh(ApplicationContext ac) {

		initStrategies(ac);
	
	}

	
	protected void initStrategies(ApplicationContext ac)
	{
		initHandlerMappings(ac);
		initHandlerAdapters(ac);
	}
	
	
	private void initHandlerMappings(ApplicationContext ac)
	{
		
		
		RequestMappingHandlerMapping  handlermapping=new  RequestMappingHandlerMapping();
		handlermapping.setBeanfactory(((XmlWebApplicationContext)ac).getBeanFactory());
		handlermapping.initHandlerMethod();
		handlerMappings.add(handlermapping);
	}
	
	
	private void initHandlerAdapters(ApplicationContext ac)
	{
		
	}


	@Override
	protected void doService(HttpServletRequest req, HttpServletResponse resp) {

	
		doDispath(req,resp);
	}
	
	
	
	protected void doDispath(HttpServletRequest request, HttpServletResponse response){
		
		
		HandlerMethod method=getHandler(request);
		try {
			method.getMethod().invoke(method.getBean(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected HandlerMethod getHandler(HttpServletRequest request)
	{
		for(HandlerMapping hm:this.handlerMappings)
		{
			HandlerMethod handler=hm.getHandler(request);
			
			if(handler!=null)
			{
				return handler;
			}
		}
		
		return null;
	}
	
}
