package SpringFrameWork.Bean.Factory.XML;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import SpringFrameWork.Bean.Factory.Support.BeanDefinitionRegistry;
import SpringFrameWork.Bean.Factory.Support.GenericBeanDefinition;
import SpringFrameWork.Core.io.ResourceLoader;







public class DefaultBeanDefinitionDocumentReader implements
		BeanDefinitionDocumentReader {

	private BeanDefinitionParserDelegate delegate=new BeanDefinitionParserDelegate();
	
	private BeanDefinitionRegistry  res;
	

	@Override
	public BeanDefinitionRegistry getRes() {
		return this.res;
	}


	@Override
	public void setRes(BeanDefinitionRegistry res) {
		this.res=res;
		this.delegate.setRes(res);
	}
	


	public void registerBeanDefinitions(Document doc) {

		
		Element root = doc.getRootElement();
		doRegisterBeanDefinitions(root);
	}
	
	
	protected void doRegisterBeanDefinitions(Element root) {
		
		BeanDefinitionParserDelegate  bdpd=new BeanDefinitionParserDelegate();
		
		
		parseBeanDefinitions(root, this.delegate);
		
	}
	
	protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
		
		List list= root.elements();
		
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Element ele=(Element) it.next();
			if(ele.getName().equals("bean"))
			{
				//System.out.println("22222222");
				parseDefaultElement(ele,delegate);
			}
			
			else if(ele.getName().equals("component-scan"))
			  {
				//System.out.println("11111111");
				this.delegate.parseCustomElement(ele);
			  }
			
		}
		
	}

	private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
		//在这里要判断处理那种bean  例如bean 或 aop 等 子element  这里简化为只有bean
		processBeanDefinition(ele,delegate);
		
		
	}

	protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {
		GenericBeanDefinition  bean=new GenericBeanDefinition();
		
		bean=(GenericBeanDefinition) delegate.parseBeanDefinitionElement(ele, bean);
		
		
		
		this.res.registerBeanDefinition(bean.getBeanClassName(), bean);
		
	}


	
	
}
