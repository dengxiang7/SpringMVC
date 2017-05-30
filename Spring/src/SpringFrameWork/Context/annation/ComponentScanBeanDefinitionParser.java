package SpringFrameWork.Context.annation;



import org.dom4j.Element;

import SpringFrameWork.Bean.Factory.Config.BeanDefinition;
import SpringFrameWork.Bean.Factory.XML.BeanDefinitionParser;
import SpringFrameWork.Bean.Factory.XML.ParserContext;
import SpringFrameWork.Util.StringUtil;

public class ComponentScanBeanDefinitionParser implements BeanDefinitionParser {

	
	private static final String BASE_PACKAGE_ATTRIBUTE = "base-package";

	private static final String RESOURCE_PATTERN_ATTRIBUTE = "resource-pattern";

	private static final String USE_DEFAULT_FILTERS_ATTRIBUTE = "use-default-filters";

	private static final String ANNOTATION_CONFIG_ATTRIBUTE = "annotation-config";

	private static final String NAME_GENERATOR_ATTRIBUTE = "name-generator";

	private static final String SCOPE_RESOLVER_ATTRIBUTE = "scope-resolver";

	private static final String SCOPED_PROXY_ATTRIBUTE = "scoped-proxy";

	private static final String EXCLUDE_FILTER_ELEMENT = "exclude-filter";

	private static final String INCLUDE_FILTER_ELEMENT = "include-filter";

	private static final String FILTER_TYPE_ATTRIBUTE = "type";

	private static final String FILTER_EXPRESSION_ATTRIBUTE = "expression";
	
	
	
	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		
		String ba=element.attributeValue(BASE_PACKAGE_ATTRIBUTE);
		
		String [] basePackage=StringUtil.spliteByExpe(ba, ";");
		
		ClassPathBeanDefinitionScanner  scanner=new ClassPathBeanDefinitionScanner(parserContext.getRes());
		
		scanner.doScan(basePackage);
		
		return null;
	}

}
