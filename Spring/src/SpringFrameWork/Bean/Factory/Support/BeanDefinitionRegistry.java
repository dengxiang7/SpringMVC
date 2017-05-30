package SpringFrameWork.Bean.Factory.Support;

import SpringFrameWork.Bean.Factory.Config.BeanDefinition;



public interface BeanDefinitionRegistry {

	
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	void removeBeanDefinition(String beanName);
	
	void registerBeanDefinitionNames(String beanName);
	
	BeanDefinition getBeanDefinition(String beanName);
	
	int getBeanDefinitionCount();
	
	String[] getBeanDefinitionNames();
}
