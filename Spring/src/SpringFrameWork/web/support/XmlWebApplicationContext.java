package SpringFrameWork.web.support;

import SpringFrameWork.Bean.Factory.Support.DefaultListableBeanFactory;
import SpringFrameWork.Bean.Factory.Support.XmlBeanDefinitionReader;

public class XmlWebApplicationContext extends
		AbstractRefreshableWebApplicationContext {

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
		
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(
				beanFactory, this);

		
		loadBeanDefinitions(beanDefinitionReader);
	}

	
	
	protected void loadBeanDefinitions(XmlBeanDefinitionReader reader)
	{
		String configLocations = this.getConfigLocations();
		
		reader.loadBeanDefinitions(configLocations);
	}
	
	
}
