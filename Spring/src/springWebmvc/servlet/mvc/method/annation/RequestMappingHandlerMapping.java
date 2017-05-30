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
		
		//��ȡ������RequestMappingע����Ϣ
		RequestMapping MethodAnnation=AnnotationUtils.findAnnotation(method, RequestMapping.class);
		if(MethodAnnation!=null)
		{
			//���ݷ����ϵ�RequsetMappingע����Զ�������,����ƥ������.��ߵ�ƥ����������http method,request parameter,request header��
			Info=createRequestMappingInfo(MethodAnnation);
			
			//��ȡ���ϵ�RequestMappingע����Ϣ
			RequestMapping TypeAnnation=AnnotationUtils.findAnnotation(clazz, RequestMapping.class);
			if(TypeAnnation!=null)
			{
				//�����ϵ�RequestMapping �ͷ�����RequestMapping �ϲ�
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
