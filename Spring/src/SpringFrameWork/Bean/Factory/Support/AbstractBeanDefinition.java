package SpringFrameWork.Bean.Factory.Support;



import java.util.ArrayList;
import java.util.List;





import SpringFrameWork.Bean.PropertyValue;
import SpringFrameWork.Bean.Factory.Config.BeanDefinition;
import SpringFrameWork.Core.io.Resource;

public abstract  class AbstractBeanDefinition implements BeanDefinition {

	
	
	private String factoryBeanName;

	private String description;

	private Resource resource;
	
	private  Object beanClass;
	
	
	private String classpath;
	
	
	private String beanClassName;
	
	private final List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>(0);

	public Object getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Object beanClass) {
		this.beanClass = beanClass;
	}

	public List<PropertyValue> getPropertyValueList() {
		return propertyValueList;
	}

	public String getClasspath() {
		return classpath;
	}

	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}

	@Override
	public String getParentName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParentName(String parentName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBeanClassName() {
		// TODO Auto-generated method stub
		return this.beanClassName;
	}

	@Override
	public void setBeanClassName(String beanClassName) {
		// TODO Auto-generated method stub
		this.beanClassName=beanClassName;
	}

	@Override
	public String getFactoryBeanName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFactoryBeanName(String factoryBeanName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResourceDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDefinition getOriginatingBeanDefinition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
