package SpringFrameWork.Context.support;

import SpringFrameWork.Bean.Factory.Support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplicationContext extends
		AbstractApplicationContext {

	private DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
	
	
	
	@Override
	public DefaultListableBeanFactory getBeanFactory() {
		return this.beanFactory;
	}


	@Override
	protected void refreshBeanFactory() {
		//DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();	

		loadBeanDefinitions(beanFactory);
	}

	
	protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);
	
	protected String getConfigLocations() {
		return  this.getLocation();
	}
}
