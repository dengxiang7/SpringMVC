package springWebmvc.servlet.mvc.condition;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class RequestMethodsRequestCondition extends AbstractRequestCondition<RequestMethodsRequestCondition> {

	
	private final Set<String> method=new LinkedHashSet<String>();
	
	public RequestMethodsRequestCondition( String [] m)
	{
		for(String met:m)
		{
			this.method.add(met);
		}
		
		
	}
	
	
	
	
	public Set<String> getMethod() {
		return method;
	}




	@Override
	public RequestMethodsRequestCondition combine(
			RequestMethodsRequestCondition other) {
		
		Set<String> m=new LinkedHashSet<String>();
		m=other.getMethod();
		m.addAll(this.getMethod());
		
		return new RequestMethodsRequestCondition((String[]) m.toArray(new String[0]));
	}

	@Override
	public RequestMethodsRequestCondition getMatchingCondition(
			HttpServletRequest request) {
		return null;
	}

	@Override
	public int compareTo(RequestMethodsRequestCondition other,
			HttpServletRequest request) {
		return 0;
	}

}
