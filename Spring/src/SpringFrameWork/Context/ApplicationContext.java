package SpringFrameWork.Context;



import SpringFrameWork.Bean.Factory.BeanFactory;

public interface ApplicationContext extends BeanFactory {

	String getId();
	
	String getApplicationName();
	
	ApplicationContext getParent();
	
}
