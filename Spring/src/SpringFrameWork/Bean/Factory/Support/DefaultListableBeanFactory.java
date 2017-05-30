package SpringFrameWork.Bean.Factory.Support;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

























import SpringFrameWork.Bean.PropertyValue;
import SpringFrameWork.Bean.Factory.BeanFactory;
import SpringFrameWork.Bean.Factory.Config.BeanDefinition;
import SpringFrameWork.Util.StringUtil;

public  class DefaultListableBeanFactory implements BeanFactory ,BeanDefinitionRegistry{

	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
	
	private final Map<Class<?>, String[]> allBeanNamesByType = new HashMap<Class<?>, String[]>();

	private  List<String> beanDefinitionNames = new ArrayList<String>();

	
	
	public DefaultListableBeanFactory ()
	{
		
	}
	
	@Override
	public Object getBean(String name) {
		
		String path=this.getBeanDefinition(name).getClasspath();
		
		try {
			
			return doGetBean(name,Class.forName(path));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) {
		
		String path=this.getBeanDefinition(name).getClasspath();
		
		try {
			if(Class.forName(path) == requiredType)
			{
				
					//return (T) Class.forName(path).newInstance();
				return doGetBean(name,requiredType);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType) {
		
		for(String name:this.getBeanDefinitionNames())
		{
			String path=this.getBeanDefinition(name).getClasspath();
			
			try {
				if(Class.forName(path) == requiredType)
				{
					
						//return (T) Class.forName(path).newInstance();
					return doGetBean(name,requiredType);
					
				}
			} catch (Exception e) {
				
			}
		}
		
		return null;
	}

	
	
	
	protected <T> T doGetBean(String name,Class clazz)
	{
		Object bean=null;
		try {
			bean=clazz.newInstance();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		GenericBeanDefinition gbd=(GenericBeanDefinition) this.getBeanDefinition(name);
		
		List list=gbd.getPropertyValueList();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			PropertyValue pv=(PropertyValue) it.next();
			String Pname=pv.getName();
			Object rv=pv.getValue();
			
			
			try {
				
				Field field=clazz.getDeclaredField(Pname);
				
				if(field!=null)
				{
					String setName=StringUtil.CharAtIndex("set"+Pname, 3);
					
					Class fieldType=field.getType();
					if(fieldType == String.class)
					{
						Method method=clazz.getMethod(setName, String.class);
						String sv=(String) rv;
						method.invoke(bean, sv);
					}else{
						String sv=(String) rv;
						String proPath= this.getBeanDefinition(sv).getClasspath();
						fieldType=Class.forName(proPath);
							
						
						
						Method method=clazz.getMethod(setName, fieldType);
						method.invoke(bean, doGetBean(sv,fieldType));
					}
					
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return (T) bean;
	}
	
	
	
	
	
	
	@Override
	public boolean containsBean(String name) {
		
		for(String temp:this.getBeanDefinitionNames())
		{
			if(name.equals(temp))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Class<?> getType(String name) {
		
		for(String temp:this.getBeanDefinitionNames())
		{
			if(name.equals(temp))
			{
				String path=this.getBeanDefinition(name).getClasspath();
				try {
					return Class.forName(path);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public String[] getAliases(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerBeanDefinition(String beanName,
			BeanDefinition beanDefinition) {

		this.beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	public void removeBeanDefinition(String beanName) {

		this.beanDefinitionMap.remove(beanName);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) {
		return this.beanDefinitionMap.get(beanName);
	}

	@Override
	public int getBeanDefinitionCount() {
		// TODO Auto-generated method stub
		return this.beanDefinitionMap.size();
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return (String[]) this.beanDefinitionMap.keySet().toArray(new String[0]);
	}

	@Override
	public void registerBeanDefinitionNames(String beanName) {

		this.beanDefinitionNames.add(beanName);
		
	}
	
	
	

}
