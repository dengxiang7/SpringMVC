package SpringFrameWork.Context.support;

import SpringFrameWork.Core.io.FileSystemResource;
import SpringFrameWork.Core.io.Resource;



public class FileSystemXmlApplicationContext extends AbstractXmlApplicationContext {

     public FileSystemXmlApplicationContext(String ConfigLocation)
     {
    	 this(ConfigLocation,true);
     }
     
     public FileSystemXmlApplicationContext(String ConfigLocation,boolean refresh)
     {
    	 this.setLocation(ConfigLocation);
 		if (refresh) {
 			refresh();
 		}
     }
	
     
     public Resource getResourceByPath(String path) {
 		if (path != null && path.startsWith("/")) {
 			path = path.substring(1);
 		}
 		
 		return new FileSystemResource(path);
 	}
     
}
