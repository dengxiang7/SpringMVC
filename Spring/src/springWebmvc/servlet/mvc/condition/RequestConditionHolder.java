package springWebmvc.servlet.mvc.condition;

import javax.servlet.http.HttpServletRequest;

public class RequestConditionHolder extends AbstractRequestCondition<RequestConditionHolder> {

	
	
	
	//��������6���Ѿ���ȷ��  ƥ������ �������Զ��������  
	//��������������װ��
	
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
