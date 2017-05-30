package SpringFrameWork.Core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class FileSystemResource extends AbstractResource {

	private final  File file;

	private final String path;
	
	
	public FileSystemResource(String path)
	{
		this.file=new File(path);
		this.path=path;
	}
	
	public FileSystemResource(File file)
	{
		this.file=file;
		this.path=file.getAbsolutePath();
	}
	

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(this.file);
	}

	@Override
	public boolean exists() {
		return super.exists();
	}

	@Override
	public boolean isReadable() {
		// TODO Auto-generated method stub
		return super.isReadable();
	}

	@Override
	public URL getURL() throws IOException {
		return this.file.toURI().toURL();
	}

	@Override
	public URI getURI() throws IOException {
		return this.file.toURI();
	}

	@Override
	public File getFile() throws IOException {
		return this.file;
	}

	@Override
	public String getFilename() {
		return this.file.getName();
	}

	@Override
	public String getDescription() {
		return "fiel:"+this.getFilename()+": path:"+this.file.getAbsolutePath();
	}

	@Override
	public String getPath() {
		
		return this.path;
	}
	
	
	
}
