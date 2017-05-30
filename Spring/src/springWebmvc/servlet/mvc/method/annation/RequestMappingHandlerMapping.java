package springWebmvc.servlet.mvc.method.annation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Set;

import SpringFrameWork.Core.annation.AnnotationUtils;
import SpringFrameWork.stereotype.Controller;
import SpringFrameWork.stereotype.RequestMapping;
import springWebmvc.servlet.mvc.condition.ConsumesRequestCondition;
import springWebmvc.servlet.mvc.condition.HeadersRequestCondition;
import springWebmvc.servlet.mvc.condition.ParamsRequestCondition;
import springWebmvc.servlet.mvc.condition.PatternsRequestCondition;
import springWebmvc.servlet.mvc.condition.ProducesRequestCondition;
import springWebmvc.servlet.mvc.condition.RequestCondition;
import springWebmvc.servlet.mvc.condition.RequestMethodsRequestCondition;
import springWebmvc.servlet.mvc.method.RequestMappingInfo;
import springWebmvc.servlet.mvc.method.RequestMappingInfoHandlerMapping;

public class RequestMappingHandlerMapping extends
		RequestMappingInfoHandlerMapping {

	
	
	
	
	
	@Override
	protected boolean isHandler(Class type) {
		
		if(type.isAnnotationPresent(Controller.class)||type.isAnnotationPresent(RequestMapping.class))
		{
			return true;
		}
		
		return false;
	}

	
	@Override
	protected RequestMappingInfo getMappingForMethod(Method method,
			Class<?> clazz) {
		
		RequestMappingInfo Info=null;
		
		//读取方法上RequestMapping注解信息
		RequestMapping MethodAnnation=AnnotationUtils.findAnnotation(method, RequestMapping.class);
		if(MethodAnnation!=null)
		{
			//根据方法上的RequsetMapping注解和自定义条件,生成匹配条件.这边的匹配条件包括http method,request parameter,request header等
			Info=createRequestMappingInfo(MethodAnnation);
			
			//读取类上的RequestMapping注解信息
			RequestMapping TypeAnnation=AnnotationUtils.findAnnotation(clazz, RequestMapping.class);
			if(TypeAnnation!=null)
			{
				//把类上的RequestMapping 和方法上RequestMapping 合并
				Info=createRequestMappingInfo(TypeAnnation).combine(Info);
			}
		}
		
		return Info;
	}

	
	
	protected RequestMappingInfo createRequestMappingInfo(RequestMapping requestMapping)
	{
		
		
	return new RequestMappingInfo(
			new ConsumesRequestCondition(),
			 new HeadersRequestCondition(),
			 new ParamsRequestCondition(),
			 new PatternsRequestCondition(requestMapping.value()),
			 new ProducesRequestCondition(),
			 new RequestMethodsRequestCondition(requestMapping.method())
			);
	}
	
	protected RequestMappingInfo createRequestMappingInfo(RequestMapping requestMapping, RequestCondition<?> customCondition)
		{
		
		return null;
		}
}
