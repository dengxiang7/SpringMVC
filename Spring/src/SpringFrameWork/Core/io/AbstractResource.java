package SpringFrameWork.Core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public abstract class AbstractResource implements Resource {

	

	@Override
	public boolean exists() {
		try {
			 this.getFile().exists();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("文件不存在！");
			return false;
		}
		return true;
	}

	@Override
	public boolean isReadable() {
		return true;
	}

	@Override
	public URL getURL() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getURI() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getFile() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
