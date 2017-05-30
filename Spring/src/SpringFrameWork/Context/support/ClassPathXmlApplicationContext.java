package SpringFrameWork.Context.support;

public class ClassPathXmlApplicationContext extends
		AbstractXmlApplicationContext {
	
	public ClassPathXmlApplicationContext(String location)
	{
		this(location,true);
	}
	
	public ClassPathXmlApplicationContext(String location,boolean refresh)
	{
		this.setLocation(location);
		if(refresh)
		{
			refresh();
		}
	}

}
