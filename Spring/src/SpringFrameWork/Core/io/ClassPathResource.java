package SpringFrameWork.Core.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource extends AbstractResource {

	
	public String path;
	
	
	public String getPath() {
		return path;
	}


	public ClassPathResource(String path)
	{
		this.path=path;
	}
	
	
	@Override
	public InputStream getInputStream() throws IOException {

		InputStream is=null;
		//System.out.println("cp   path:"+this.path);
		//is= ClassLoader.getSystemResourceAsStream(this.path);
		is= this.getClass().getClassLoader().getResourceAsStream(this.path);
		//System.out.println("cp:"+is);
		return is;
	}

}
