package springWebmvc.servlet.web.method;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import SpringFrameWork.stereotype.RequestMapping;

public class HandlerMethodSelector {
	
	
	public static Set<Method> selectMethod(Class<?> clazz)
	{
		Set<Method> RequestMappingMethod =new HashSet<Method>();
		
		Method [] methods=clazz.getMethods();
		
		for(Method method:methods)
		{
			if(method.isAnnotationPresent(RequestMapping.class))
			{
				RequestMappingMethod.add(method);
			}
		}
		
		return RequestMappingMethod;
	}

}
