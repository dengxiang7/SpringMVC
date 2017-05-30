package springWebmvc.servlet.mvc.method;

import javax.servlet.http.HttpServletRequest;

import springWebmvc.servlet.mvc.condition.ConsumesRequestCondition;
import springWebmvc.servlet.mvc.condition.HeadersRequestCondition;
import springWebmvc.servlet.mvc.condition.ParamsRequestCondition;
import springWebmvc.servlet.mvc.condition.PatternsRequestCondition;
import springWebmvc.servlet.mvc.condition.ProducesRequestCondition;
import springWebmvc.servlet.mvc.condition.RequestCondition;
import springWebmvc.servlet.mvc.condition.RequestConditionHolder;
import springWebmvc.servlet.mvc.condition.RequestMethodsRequestCondition;

public class RequestMappingInfo implements RequestCondition<RequestMappingInfo> {

	
	//private final String name;
	
	//private final RequestConditionHolder  requestConditionHolder;
	
	private final ConsumesRequestCondition consumesRequestCondition;
	
	private final HeadersRequestCondition headersRequestCondition;
	
	private final ParamsRequestCondition paramsRequestCondition;
	
	private final PatternsRequestCondition patternsRequestCondition;
	
	private final ProducesRequestCondition roducesRequestCondition;
	
	private final RequestMethodsRequestCondition requestMethodsRequestCondition;
	
	public RequestMappingInfo(ConsumesRequestCondition consumesRequestCondition,
			HeadersRequestCondition headersRequestCondition, ParamsRequestCondition paramsRequestCondition,
			PatternsRequestCondition patternsRequestCondition,ProducesRequestCondition roducesRequestCondition,
			RequestMethodsRequestCondition requestMethodsRequestCondition)
	{
		
		//this.name=name;
		this.consumesRequestCondition=consumesRequestCondition;
		this.headersRequestCondition=headersRequestCondition;
		this.paramsRequestCondition=paramsRequestCondition;
		this.patternsRequestCondition=patternsRequestCondition;
		this.roducesRequestCondition=roducesRequestCondition;
		this.requestMethodsRequestCondition=requestMethodsRequestCondition;
		
	}
	
	
	
	@Override
	public RequestMappingInfo combine(RequestMappingInfo other) {
		
	//	String name=other.name;
		
		  ConsumesRequestCondition consumes=this.consumesRequestCondition.combine(other.consumesRequestCondition);
		
		  HeadersRequestCondition headers=this.headersRequestCondition.combine(other.headersRequestCondition);
		
		  ParamsRequestCondition params=this.paramsRequestCondition.combine(other.paramsRequestCondition);
		
		  PatternsRequestCondition patterns=this.patternsRequestCondition.combine(other.patternsRequestCondition);
		
		  ProducesRequestCondition roduces=this.roducesRequestCondition.combine(other.roducesRequestCondition);
		
		  RequestMethodsRequestCondition requestMethods=this.requestMethodsRequestCondition.combine(other.requestMethodsRequestCondition);
		
		return new RequestMappingInfo(consumes,headers,params,patterns,roduces,requestMethods);
	}

	@Override
	public RequestMappingInfo getMatchingCondition(HttpServletRequest request) {
		return null;
	}

	@Override
	public int compareTo(RequestMappingInfo other, HttpServletRequest request) {
		return 0;
	}



	public ConsumesRequestCondition getConsumesRequestCondition() {
		return consumesRequestCondition;
	}



	public HeadersRequestCondition getHeadersRequestCondition() {
		return headersRequestCondition;
	}



	public ParamsRequestCondition getParamsRequestCondition() {
		return paramsRequestCondition;
	}



	public PatternsRequestCondition getPatternsRequestCondition() {
		return patternsRequestCondition;
	}



	public ProducesRequestCondition getRoducesRequestCondition() {
		return roducesRequestCondition;
	}



	public RequestMethodsRequestCondition getRequestMethodsRequestCondition() {
		return requestMethodsRequestCondition;
	}

	
	
}
