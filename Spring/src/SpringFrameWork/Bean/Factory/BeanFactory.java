package SpringFrameWork.Bean.Factory;

public interface BeanFactory {

	Object getBean(String name);
	
	<T> T getBean(String name, Class<T> requiredType);
	
	<T> T getBean(Class<T> requiredType);
	
	boolean containsBean(String name);
	
	Class<?> getType(String name) ;
	
	String[] getAliases(String name);
	
}
