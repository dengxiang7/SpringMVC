package SpringFrameWork.Context.support;



import SpringFrameWork.Bean.Factory.Support.DefaultListableBeanFactory;
import SpringFrameWork.Bean.Factory.Support.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends
		AbstractRefreshableApplicationContext {

	
	
	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
		
		loadBeanDefinitions(beanDefinitionReader);
	}

	
	protected void loadBeanDefinitions(XmlBeanDefinitionReader reader)
	{
		String configLocations = this.getConfigLocations();
		
		reader.loadBeanDefinitions(configLocations);
	}
	
}
