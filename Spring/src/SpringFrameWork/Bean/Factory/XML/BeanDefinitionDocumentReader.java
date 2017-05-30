package SpringFrameWork.Bean.Factory.XML;

import org.dom4j.Document;

import SpringFrameWork.Bean.Factory.Support.BeanDefinitionRegistry;
import SpringFrameWork.Core.io.ResourceLoader;




public interface BeanDefinitionDocumentReader {

	void registerBeanDefinitions(Document doc);
	
	public BeanDefinitionRegistry getRes() ;



	public void setRes(BeanDefinitionRegistry res) ;
		
	

}
