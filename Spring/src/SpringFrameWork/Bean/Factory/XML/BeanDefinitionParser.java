package SpringFrameWork.Bean.Factory.XML;




import org.dom4j.Element;

import SpringFrameWork.Bean.Factory.Config.BeanDefinition;

public interface BeanDefinitionParser {

	
	BeanDefinition parse(Element element, ParserContext parserContext);
	
	
}
