package test;

import SpringFrameWork.stereotype.Controller;
import SpringFrameWork.stereotype.RequestMapping;

@Controller
@RequestMapping(value="/test" ,method={"Get"})
public class student {

	
	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@RequestMapping(value="/testMVC" ,method={"GET" ,"POST"})
	public void testMVC()
	{
		System.out.println("this is testMVC");
	}
	
	@RequestMapping(value="/testMVC2" ,method={"GET"})
	public void testMVC2()
	{
		System.out.println("this is testMVC 2 。。。。。。");
	}
}
