package SpringFrameWork.Bean.Factory.Support;



import java.util.Set;

import SpringFrameWork.Context.support.AbstractRefreshableApplicationContext;
import SpringFrameWork.Core.io.Resource;
import SpringFrameWork.Core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	private  BeanDefinitionRegistry registry;
	
	private ResourceLoader resourceLoader;

	
	
	public AbstractBeanDefinitionReader(DefaultListableBeanFactory registry,ResourceLoader resLoader)
	{
		this.registry= registry;
		this.resourceLoader=resLoader;
	}
	
	public void setRegistry(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public BeanDefinitionRegistry getRegistry() {
		// TODO Auto-generated method stub
		return this.registry;
	}

	@Override
	public ResourceLoader getResourceLoader() {
		// TODO Auto-generated method stub
		return this.resourceLoader;
	}

	

	@Override
	public int loadBeanDefinitions(String location) {
		// TODO Auto-generated method stub
		return loadBeanDefinitions(location,null);
	}

	public int loadBeanDefinitions(String location, Resource actualResources) 
	{
		Resource resource = resourceLoader.getResource(location);
		//System.out.println("’“µΩResource £∫"+resource.getPath());
		loadBeanDefinitions(resource);
		return 0;
	}
	
}
