package springWebmvc.servlet.mvc.method;

import java.lang.reflect.Method;
import java.util.Set;

import springWebmvc.servlet.handler.AbstractHandlerMethodMapping;

public abstract class RequestMappingInfoHandlerMapping extends
		AbstractHandlerMethodMapping<RequestMappingInfo> {

	
	
	
	@Override
	protected Set<String> getMappingPathPatterns(RequestMappingInfo mapping) {
		return null;
	}

	
	
	

	

}
