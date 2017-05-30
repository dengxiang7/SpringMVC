package SpringFrameWork.Context.annation;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Set;











import SpringFrameWork.Bean.Factory.Config.BeanDefinition;
import SpringFrameWork.Bean.Factory.Support.BeanDefinitionRegistry;
import SpringFrameWork.Bean.Factory.Support.GenericBeanDefinition;
import SpringFrameWork.Util.StringUtil;

public class ClassPathBeanDefinitionScanner extends
		ClassPathScanningCandidateComponentProvider {

	
private final BeanDefinitionRegistry registry;
	
	
	public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry reg)
	{
		this.registry=reg;
	}
	
	
	
	protected Set<BeanDefinition> doScan(String ...basePackages)
	{
		
		for(String str:basePackages)
		{
			
			scan(str);
			
		}
		
		
		
		
		return null;
	}
	
	
	public void scan(String basepackage) 
	{
		URL url=this.getClass().getResource("/"+StringUtil.replaceTo(basepackage, "\\.", "/"));
		        
		String path=url.getFile();
		
		//处理空格等字符，换位中文字符集utf-8
		try {
			path=StringUtil.StringDecode(path,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		File file=new File(path);
		
		if(!file.exists())
		{
			System.out.println("文件不存在！");
			return ;
		}
		
	    String []	filename=file.list();

		for(String name:filename)
		{
			File fi=new File(path+name);
			
			if(fi.isDirectory())
			{
				scan(basepackage +"."+ fi.getName());
			}
			else
			{
				String BeanNamePath=basepackage +"."+ fi.getName();
				
				GenericBeanDefinition bean=new GenericBeanDefinition();
				
				if(fi.getName().endsWith(".class"))
				{
					
					//System.out.println("注解否："+Class.forName(BeanNamePath.substring(0, BeanNamePath.length()-6)));
					String beanid=fi.getName();
					bean.setBeanClassName(beanid.substring(0, beanid.length()-6));
					bean.setClasspath(BeanNamePath.substring(0, BeanNamePath.length()-6));
					//System.out.println("id"+beanid.substring(0, beanid.length()-6)+"   class:"+Class.forName(BeanNamePath.substring(0, BeanNamePath.length()-6)));
					this.registry.registerBeanDefinitionNames(beanid.substring(0, beanid.length()-6));
					this.registry.registerBeanDefinition(beanid.substring(0, beanid.length()-6), bean);
				}
				
				
			}
		}
	}
	
	
	
	
}
