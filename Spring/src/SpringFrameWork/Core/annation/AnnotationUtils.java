package SpringFrameWork.Core.annation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import SpringFrameWork.stereotype.RequestMapping;

public abstract class AnnotationUtils {

	
	
	public static <A extends Annotation> A findAnnotation(Method method,Class<A> annotationType)
	{
		
		A result=null;
		
		//�����������ڵ���  
		Class<?> clazz=method.getDeclaringClass();
		
		result=method.getAnnotation(annotationType);
		
		
		return result;
	}
	
	
	
	public static <A extends Annotation> A findAnnotation(Class<?> clazz,Class<A> annotationType)
	{
		
		A result=null;
		result=clazz.getAnnotation(annotationType);
		
		return result;
	}
}
