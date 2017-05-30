package springWebmvc.servlet.mvc.condition;

import javax.servlet.http.HttpServletRequest;

public class CompositeRequestCondition extends AbstractRequestCondition<CompositeRequestCondition> {

	private final RequestConditionHolder[] requestConditions;
	
	public CompositeRequestCondition(RequestCondition<?> ... requestCondition)
	{
		this.requestConditions=wrap(requestCondition);
	}
	
	public CompositeRequestCondition(RequestConditionHolder[] requestCondition)
	{
		this.requestConditions=requestCondition;
	}
	
	private RequestConditionHolder[] wrap(RequestCondition<?>... rawConditions) {
		
		RequestConditionHolder []  holder=new RequestConditionHolder[rawConditions.length];
		
		for(int i=0;i<rawConditions.length;i++)
		{
			holder[i]=new RequestConditionHolder(rawConditions[i]);
		}
		
		return holder;
	}
	
	
	@Override
	public CompositeRequestCondition combine(CompositeRequestCondition other) {
		return null;
	}

	@Override
	public CompositeRequestCondition getMatchingCondition(
			HttpServletRequest request) {
		return null;
	}

	@Override
	public int compareTo(CompositeRequestCondition other,
			HttpServletRequest request) {
		return 0;
	}

}
