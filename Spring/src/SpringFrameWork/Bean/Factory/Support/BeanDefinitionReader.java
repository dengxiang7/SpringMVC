package SpringFrameWork.Bean.Factory.Support;





import SpringFrameWork.Core.io.Resource;
import SpringFrameWork.Core.io.ResourceLoader;



public interface BeanDefinitionReader {

	
	BeanDefinitionRegistry getRegistry();
	
	ResourceLoader getResourceLoader();
	
	int loadBeanDefinitions(Resource resource) ;
	
	int loadBeanDefinitions(String location) ;
}
