package SpringFrameWork.Core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public interface Resource {

	InputStream getInputStream() throws IOException;
	
	boolean exists();
	
	boolean isReadable();
	
	URL getURL() throws IOException;
	
	URI getURI() throws IOException;
	
	File getFile() throws IOException;
	
	String getFilename();
	
	String getDescription();
	
	String getPath();
}
