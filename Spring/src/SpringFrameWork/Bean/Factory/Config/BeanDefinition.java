package SpringFrameWork.Bean.Factory.Config;

import java.util.List;

import SpringFrameWork.Bean.PropertyValue;



public interface BeanDefinition {

	void setAttribute(String name, Object value);
	
	Object getAttribute(String name);
	
	Object removeAttribute(String name);
	
	boolean hasAttribute(String name);
	
	String[] attributeNames();
	
	
	
	
	
	String getParentName();
	
	void setParentName(String parentName);
	
	String getBeanClassName();
	
	void setBeanClassName(String beanClassName);
	
	String getFactoryBeanName();
	
	void setFactoryBeanName(String factoryBeanName);
	
	String getDescription();
	
	String getResourceDescription();
	
	BeanDefinition getOriginatingBeanDefinition();
	 
    String getClasspath() ;
	
    void setClasspath(String classpath);
    
    List<PropertyValue> getPropertyValueList();
}
