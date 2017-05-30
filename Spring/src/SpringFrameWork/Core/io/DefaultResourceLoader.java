package SpringFrameWork.Core.io;

import java.net.MalformedURLException;
import java.net.URL;


public class DefaultResourceLoader implements ResourceLoader {

	private String Location;
	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public DefaultResourceLoader()
	{
		
	}
	
	public DefaultResourceLoader(String Location)
	{
		this.Location=Location;
	}
	
	@Override
	public Resource getResource(String location) {

		
		
		if(location!=null)
		{
			
			if (location.startsWith("/")) {
				return getResourceByPath(location);
			}
			else if (location.startsWith(CLASSPATH_URL_PREFIX)) {
				
				String path=location.substring(CLASSPATH_URL_PREFIX.length());
				//System.out.println("path"+path);
				ClassPathResource res=new ClassPathResource(path);
				//System.out.println("res"+res.path);
				return res;
			}
			else {
				try {
					// Try to parse the location as a URL...
					//URL url = new URL(location);
					
					return getResourceByPath(location);
				}
				catch (Exception ex) {
					// No URL -> resolve as resource path.
				
					return getResourceByPath(location);
				}
			}
		}else
		{
			
			return null;
		}
		
		
	}
	
	protected Resource getResourceByPath(String path) {
		return null;
	}


}
