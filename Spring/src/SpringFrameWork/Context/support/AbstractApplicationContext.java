package SpringFrameWork.Context.support;

import SpringFrameWork.Bean.Factory.Support.DefaultListableBeanFactory;
import SpringFrameWork.Context.ApplicationContext;
import SpringFrameWork.Core.io.DefaultResourceLoader;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ApplicationContext {

	
	public abstract DefaultListableBeanFactory getBeanFactory();
	
	@Override
	public Object getBean(String name) {
		
		return this.getBeanFactory().getBean(name);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) {
		return this.getBeanFactory().getBean(name, requiredType);
	}

	@Override
	public <T> T getBean(Class<T> requiredType) {
		return this.getBeanFactory().getBean(requiredType);
	}

	@Override
	public boolean containsBean(String name) {
		return this.getBeanFactory().containsBean(name);
	}

	@Override
	public Class<?> getType(String name) {
		return this.getBeanFactory().getType(name);
	}

	@Override
	public String[] getAliases(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationContext getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	public void refresh(){
		
		
		DefaultListableBeanFactory	beanFactory = obtainFreshBeanFactory();
		
	}
	
	protected DefaultListableBeanFactory obtainFreshBeanFactory(){
		refreshBeanFactory();
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		return beanFactory;
	
		
	}
	
	
	protected abstract void refreshBeanFactory() ;
	
}
