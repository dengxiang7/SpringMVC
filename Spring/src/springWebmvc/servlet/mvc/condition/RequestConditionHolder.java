package springWebmvc.servlet.mvc.condition;

import javax.servlet.http.HttpServletRequest;

public class RequestConditionHolder extends AbstractRequestCondition<RequestConditionHolder> {

	
	
	
	//除了另外6个已经明确的  匹配条件 ，用于自定义的条件  
	//用这个外观类来包装。
	
	private final RequestCondition<Object> condition;
	
	public RequestConditionHolder(RequestCondition<?> rc)
	{
		this.condition=(RequestCondition<Object>) rc;
	}
	
	@Override
	public RequestConditionHolder combine(RequestConditionHolder other) {
		return null;
	}

	@Override
	public RequestConditionHolder getMatchingCondition(
			HttpServletRequest request) {
		return null;
	}

	@Override
	public int compareTo(RequestConditionHolder other,
			HttpServletRequest request) {
		return 0;
	}

}
