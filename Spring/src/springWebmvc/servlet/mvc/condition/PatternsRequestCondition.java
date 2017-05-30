package springWebmvc.servlet.mvc.condition;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PatternsRequestCondition extends AbstractRequestCondition<PatternsRequestCondition> {

	
	private final String content;
	
	
	
	public PatternsRequestCondition(String  patterns )
	{
		
		
		if(patterns.startsWith("/"))
		{
			this.content=patterns;
		}
		else{
			this.content="/"+patterns;
		}
	}
	
	
	public String getContent() {
		return content;
	}


	

	
	@Override
	public PatternsRequestCondition combine(PatternsRequestCondition other) {
		
		String cont=other.getContent();
		
		
		if(cont.startsWith("/"))
		{
			cont=this.content+cont;
		}
		else
		{
			cont=this.content+"/"+cont;
		}
		
		return new PatternsRequestCondition(cont);
	}

	@Override
	public PatternsRequestCondition getMatchingCondition(
			HttpServletRequest request) {
		return null;
	}

	@Override
	public int compareTo(PatternsRequestCondition other,
			HttpServletRequest request) {
		return 0;
	}

}
