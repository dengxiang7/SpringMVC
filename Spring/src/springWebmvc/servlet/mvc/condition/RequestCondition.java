package springWebmvc.servlet.mvc.condition;

import javax.servlet.http.HttpServletRequest;





public interface RequestCondition<T> {

	
	T combine(T other);
	
	T getMatchingCondition(HttpServletRequest request);
	
	int compareTo(T other, HttpServletRequest request);
}
