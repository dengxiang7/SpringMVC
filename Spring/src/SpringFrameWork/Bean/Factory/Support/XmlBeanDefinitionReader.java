package SpringFrameWork.Bean.Factory.Support;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;




import org.dom4j.Document;
import org.xml.sax.InputSource;

import SpringFrameWork.Bean.Factory.XML.BeanDefinitionDocumentReader;
import SpringFrameWork.Bean.Factory.XML.DefaultBeanDefinitionDocumentReader;
import SpringFrameWork.Context.support.AbstractRefreshableApplicationContext;
import SpringFrameWork.Core.io.Resource;
import SpringFrameWork.Core.io.ResourceLoader;
import SpringFrameWork.Util.DocumentLoader;


public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	
	
	
	
	public XmlBeanDefinitionReader(DefaultListableBeanFactory registry,ResourceLoader resLoader)
	{
		super(registry,resLoader);
	}

	@Override
	public int loadBeanDefinitions(Resource resource) {
		// TODO Auto-generated method stub
		//FileInputStream fis;
		
		InputStream fis;
		try {
			fis =  resource.getInputStream();
			 doLoadBeanDefinitions(fis, resource);
			// System.out.println("res:11"+fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int loadBeanDefinitions(String location) {
		// TODO Auto-generated method stub
		return super.loadBeanDefinitions(location);
	}
	
	
//	public int loadBeanDefinitions(InputStream inputSource)
//	{
//		return doLoadBeanDefinitions(inputSource, new DescriptiveResource(resourceDescription));
//	}
	
	protected int doLoadBeanDefinitions(InputStream fis, Resource resource)
	{
		Document doc=null;
		DocumentLoader dloader=new DocumentLoader();
		try {
			
			if(resource.exists())
			{
				doc=dloader.GetDocument(resource.getFile());
			}else{
				doc=dloader.GetDocumentByInputStream(fis);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(doc!=null)
		{
			return registerBeanDefinitions(doc, resource);
		}
		return 0;
	}
	
	public int registerBeanDefinitions(Document doc, Resource resource)
	{
		BeanDefinitionDocumentReader documentReader =new DefaultBeanDefinitionDocumentReader();
		documentReader.setRes(this.getRegistry());
		documentReader.registerBeanDefinitions(doc);
		return 0;
	}
}
