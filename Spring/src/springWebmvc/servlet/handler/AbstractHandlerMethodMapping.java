package springWebmvc.servlet.handler;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import springWebmvc.servlet.mvc.method.RequestMappingInfo;

import javax.servlet.http.HttpServletRequest;



import javax.ws.rs.core.MultivaluedMap;

import springWebmvc.servlet.HandlerMapping;
import springWebmvc.servlet.web.HandlerMethod;
import springWebmvc.servlet.web.method.HandlerMethodSelector;

public abstract class AbstractHandlerMethodMapping<T> extends AbstractHandlerMapping  {

   private MappingRegistry mappingRegistry=new MappingRegistry();
	
	
	public void initHandlerMethod(){
		
		
		
		String []names=this.getBeanfactory().getBeanDefinitionNames();
		
		for(String beanName:names)
		{
			Class type=this.getBeanfactory().getType(beanName);
			 if(type == null)
			 {
				 continue;
			 }
			 
			 if(isHandler(type))
			 {
				 detectHandlerMethods(beanName);
			 }
		}
		
	}
	
	protected void detectHandlerMethods(final Object handler){
		
		String beanName=null;
		if(handler instanceof String )
		{beanName=(String) handler;}
		Class<?> clazz=this.getBeanfactory().getType(beanName);
		
		Set<Method> methods=HandlerMethodSelector.selectMethod(clazz);
		
		for(Method method:methods)
		{
			T mapping=getMappingForMethod(method,clazz);
			registerHandlerMethod(mapping,handler,method);
		}
		
	}
	
	
	
	protected abstract boolean isHandler(Class type);
	
	
	
	@Override
	protected HandlerMethod getHandlerInternal(HttpServletRequest request) {
		
		
		String urlPath=request.getRequestURI();
		
		Set<String> urlSet=this.mappingRegistry.urlMap.keySet();
		
		for(String url:urlSet)
		{
			if(urlPath.endsWith(url))
			{
				T mapping=this.mappingRegistry.urlMap.get(url);

				String method=request.getMethod();
				
				if(((RequestMappingInfo)mapping).getRequestMethodsRequestCondition().getMethod().contains(method)
						||((RequestMappingInfo)mapping).getRequestMethodsRequestCondition().getMethod().isEmpty())
				{
					HandlerMethod handlermethod=this.mappingRegistry.handlerMethods.get(mapping);
					return handlermethod;
				}
				
				
			}
		}
		
		return null;
	}





	public HandlerMethod  createHandlerMethod(Object handler, Method method)
    {
		String beanName=null;
		if(handler instanceof String )
		{beanName=(String) handler;}
		Class<?> clazz=this.getBeanfactory().getType(beanName);
		
		
		HandlerMethod handlermethod=null;
		try {
			handlermethod = new HandlerMethod(clazz.newInstance(),method);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return handlermethod;
    }
	
	
	protected abstract T getMappingForMethod(Method method,Class<?> clazz);	
	
	
	protected void registerHandlerMethod( T mapping, Object handler,Method method) {
		this.mappingRegistry.register(mapping, handler, method);
	}
	
	
	
	protected abstract Set<String> getMappingPathPatterns(T mapping);
	
	
	
	class MappingRegistry{
		
		//handlerMethods保存匹配条件和HandlerMethod的对应关系
		private final Map<T,HandlerMethod> handlerMethods=new LinkedHashMap<T,HandlerMethod>();
		//urlMa保存url与匹配条件的对应关系  而MultiValueMap是一种一个key可以对应多个value的map
		private final Map<String, T> urlMap=  new LinkedHashMap<String, T> ();
	    //nameMap    正常不需要
	    private final  Map<String, HandlerMethod> nameMap=new LinkedHashMap<String, HandlerMethod>();
	    
	    
	    
	    public void register(T mapping,Object handler, Method method)
	    {
	    	HandlerMethod handelrmethod=createHandlerMethod(handler,method);
	    	
	    	handlerMethods.put(mapping, handelrmethod);
	    	
	    	String url=((RequestMappingInfo)mapping).getPatternsRequestCondition().getContent();
	    	//System.out.println("urlMap:"+url);
	    	urlMap.put(url, mapping);
	    }
	    
	    
	    
	}
	
	
}
