package SpringFrameWork.Bean.Factory.XML;



import SpringFrameWork.Bean.Factory.Config.BeanDefinition;
import SpringFrameWork.Bean.Factory.Support.BeanDefinitionRegistry;
import SpringFrameWork.Bean.Factory.Support.XmlBeanDefinitionReader;





public class ParserContext {
	
	
	private final BeanDefinitionParserDelegate delegate;
	
	private BeanDefinition beanDefinition;
	
	private  XmlBeanDefinitionReader reader;
	
	private BeanDefinitionRegistry  res;

	
	
	
	public XmlBeanDefinitionReader getReader() {
		return reader;
	}

	public void setReader(XmlBeanDefinitionReader reader) {
		this.reader = reader;
	}

	public BeanDefinitionRegistry getRes() {
		return res;
	}

	public void setRes(BeanDefinitionRegistry res) {
		this.res = res;
	}

	public ParserContext(BeanDefinitionRegistry  re,BeanDefinitionParserDelegate dele)
	{
		this.delegate=dele;
		this.res=re;
	}
	
	public ParserContext(BeanDefinitionRegistry  re,BeanDefinitionParserDelegate dele,BeanDefinition be)
	{
		this.delegate=dele;
		this.beanDefinition=be;
		this.res=re;
	}

	public BeanDefinition getBeanDefinition() {
		return beanDefinition;
	}

	public void setBeanDefinition(BeanDefinition beanDefinition) {
		this.beanDefinition = beanDefinition;
	}

	public BeanDefinitionParserDelegate getDelegate() {
		return delegate;
	}
	
	
	
	
}
