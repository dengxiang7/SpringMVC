package SpringFrameWork.Bean.Factory.XML;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import SpringFrameWork.Bean.PropertyValue;
import SpringFrameWork.Bean.Factory.Config.BeanDefinition;
import SpringFrameWork.Bean.Factory.Support.BeanDefinitionRegistry;
import SpringFrameWork.Bean.Factory.Support.GenericBeanDefinition;
import SpringFrameWork.Context.annation.ComponentScanBeanDefinitionParser;

public class BeanDefinitionParserDelegate {

	
	 
	public static final String TRUE_VALUE = "true";

	public static final String FALSE_VALUE = "false";

	public static final String DEFAULT_VALUE = "default";

	public static final String DESCRIPTION_ELEMENT = "description";

	public static final String AUTOWIRE_NO_VALUE = "no";

	public static final String AUTOWIRE_BY_NAME_VALUE = "byName";

	public static final String AUTOWIRE_BY_TYPE_VALUE = "byType";

	public static final String AUTOWIRE_CONSTRUCTOR_VALUE = "constructor";

	public static final String AUTOWIRE_AUTODETECT_VALUE = "autodetect";

	public static final String DEPENDENCY_CHECK_ALL_ATTRIBUTE_VALUE = "all";

	public static final String DEPENDENCY_CHECK_SIMPLE_ATTRIBUTE_VALUE = "simple";

	public static final String DEPENDENCY_CHECK_OBJECTS_ATTRIBUTE_VALUE = "objects";

	public static final String NAME_ATTRIBUTE = "name";

	public static final String BEAN_ELEMENT = "bean";

	public static final String META_ELEMENT = "meta";

	public static final String ID_ATTRIBUTE = "id";

	public static final String PARENT_ATTRIBUTE = "parent";

	public static final String CLASS_ATTRIBUTE = "class";

	public static final String ABSTRACT_ATTRIBUTE = "abstract";

	public static final String SCOPE_ATTRIBUTE = "scope";

	private static final String SINGLETON_ATTRIBUTE = "singleton";

	public static final String LAZY_INIT_ATTRIBUTE = "lazy-init";

	public static final String AUTOWIRE_ATTRIBUTE = "autowire";

	public static final String AUTOWIRE_CANDIDATE_ATTRIBUTE = "autowire-candidate";

	public static final String PRIMARY_ATTRIBUTE = "primary";

	public static final String DEPENDENCY_CHECK_ATTRIBUTE = "dependency-check";

	public static final String DEPENDS_ON_ATTRIBUTE = "depends-on";

	public static final String INIT_METHOD_ATTRIBUTE = "init-method";

	public static final String DESTROY_METHOD_ATTRIBUTE = "destroy-method";

	public static final String FACTORY_METHOD_ATTRIBUTE = "factory-method";

	public static final String FACTORY_BEAN_ATTRIBUTE = "factory-bean";

	public static final String CONSTRUCTOR_ARG_ELEMENT = "constructor-arg";

	public static final String INDEX_ATTRIBUTE = "index";

	public static final String TYPE_ATTRIBUTE = "type";

	public static final String VALUE_TYPE_ATTRIBUTE = "value-type";

	public static final String KEY_TYPE_ATTRIBUTE = "key-type";

	public static final String PROPERTY_ELEMENT = "property";

	public static final String REF_ATTRIBUTE = "ref";

	public static final String VALUE_ATTRIBUTE = "value";

	public static final String LOOKUP_METHOD_ELEMENT = "lookup-method";

	public static final String REPLACED_METHOD_ELEMENT = "replaced-method";

	public static final String REPLACER_ATTRIBUTE = "replacer";

	public static final String ARG_TYPE_ELEMENT = "arg-type";

	public static final String ARG_TYPE_MATCH_ATTRIBUTE = "match";

	public static final String REF_ELEMENT = "ref";

	public static final String IDREF_ELEMENT = "idref";

	public static final String BEAN_REF_ATTRIBUTE = "bean";

	public static final String LOCAL_REF_ATTRIBUTE = "local";

	public static final String PARENT_REF_ATTRIBUTE = "parent";

	public static final String VALUE_ELEMENT = "value";

	public static final String NULL_ELEMENT = "null";

	public static final String ARRAY_ELEMENT = "array";

	public static final String LIST_ELEMENT = "list";

	public static final String SET_ELEMENT = "set";

	public static final String MAP_ELEMENT = "map";

	public static final String ENTRY_ELEMENT = "entry";

	public static final String KEY_ELEMENT = "key";

	public static final String KEY_ATTRIBUTE = "key";

	public static final String KEY_REF_ATTRIBUTE = "key-ref";

	public static final String VALUE_REF_ATTRIBUTE = "value-ref";

	public static final String PROPS_ELEMENT = "props";

	public static final String PROP_ELEMENT = "prop";

	public static final String MERGE_ATTRIBUTE = "merge";

	public static final String QUALIFIER_ELEMENT = "qualifier";

	public static final String QUALIFIER_ATTRIBUTE_ELEMENT = "attribute";

	public static final String DEFAULT_LAZY_INIT_ATTRIBUTE = "default-lazy-init";

	public static final String DEFAULT_MERGE_ATTRIBUTE = "default-merge";

	public static final String DEFAULT_AUTOWIRE_ATTRIBUTE = "default-autowire";

	public static final String DEFAULT_DEPENDENCY_CHECK_ATTRIBUTE = "default-dependency-check";

	public static final String DEFAULT_AUTOWIRE_CANDIDATES_ATTRIBUTE = "default-autowire-candidates";

	public static final String DEFAULT_INIT_METHOD_ATTRIBUTE = "default-init-method";

	public static final String DEFAULT_DESTROY_METHOD_ATTRIBUTE = "default-destroy-method";
	
	private final GenericBeanDefinition defaults = new GenericBeanDefinition();
	
	
	
	private BeanDefinitionRegistry  res;
	
	
	
	
	public BeanDefinitionRegistry getRes() {
		return res;
	}

	public void setRes(BeanDefinitionRegistry res) {
		this.res = res;
	}

	public BeanDefinition parseBeanDefinitionElement(Element ele, BeanDefinition Bean) 
		{
		
		   String beanName=ele.attributeValue(ID_ATTRIBUTE);
		   String nameAttr=ele.attributeValue(NAME_ATTRIBUTE);
		   
		   String classpath=ele.attributeValue(CLASS_ATTRIBUTE);
		
		   
		   //对bean 进行详细解析
		   Bean=parseBeanDefinitionElement(ele,beanName,Bean);
		   
			return Bean;
		}
	
	public BeanDefinition parseBeanDefinitionElement(Element ele, String beanName, BeanDefinition Bean) {
		
		//解析bean的各种信息
		parseMetaElements(ele, Bean);
		//解析bean的property
		parsePropertyElements(ele, Bean);
		
		return Bean;
		
	}
	
	public void parseMetaElements(Element ele,BeanDefinition bean)
	{
		 String beanName=ele.attributeValue(ID_ATTRIBUTE);
		 String classpath=ele.attributeValue(CLASS_ATTRIBUTE);
		 bean.setBeanClassName(beanName);
		 bean.setClasspath(classpath);
	}
	
	public void parsePropertyElements(Element beanEle, BeanDefinition bd) {
		
		ArrayList list=(ArrayList) beanEle.elements("property");
		
		Iterator it =list.iterator();
		
		while(it.hasNext())
		{
			Element el=(Element) it.next();
			parsePropertyElement(el,bd);
		}
		
		
	}
	
	
	public void parsePropertyElement(Element beanEle, BeanDefinition bd) {
		
		String PropertyName=beanEle.attributeValue(NAME_ATTRIBUTE);
		
		List<PropertyValue> list=bd.getPropertyValueList();
		
		Iterator it =list.iterator();
		while(it.hasNext())
		{
			PropertyValue pv=(PropertyValue) it.next();
			if(pv.getName().equals(PropertyName))
			{
				return;
			}
		}
		
		
		
		String refAttr=beanEle.attributeValue(REF_ATTRIBUTE);
		String ValueAttr=beanEle.attributeValue(VALUE_ELEMENT);
		
		PropertyValue p=null;
		if(refAttr!=null)
		{
			p=new PropertyValue(PropertyName, refAttr);
			
		}else
		{
			p=new PropertyValue(PropertyName, ValueAttr);
		}
		
		bd.getPropertyValueList().add(p);
		
	}
	
	
	
	
	
	public BeanDefinition parseCustomElement(Element e)
	{
		return parseCustomElement(e,null);
	}
	
	public BeanDefinition parseCustomElement(Element ele, BeanDefinition containingBd) {
		
		
		ComponentScanBeanDefinitionParser  scanParser=new ComponentScanBeanDefinitionParser();
		
		ParserContext  pc=new ParserContext(this.res,this, containingBd);
		
		scanParser.parse(ele, pc);
		
		return null;
	}
	
}
