package SpringFrameWork.Util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class StringUtil {

	
	
	public static String CharAtIndex(String s,int index)
	{
		
		
	//	String newstr= s.substring(0, 1).toUpperCase()+s.substring(1);
	     
		char[] arr=s.toCharArray();
	    arr[index] -=32;
	    String newStr=String.valueOf(arr);
		
		
		return newStr;
	}
	
	
	
	
	public static String []   spliteByExpe(String str,String ex)
	{
		
		String [] arr=str.split(ex);
		
		return arr;
	}
	
	
	public static String replaceTo(String str,String old,String New)
	{
		String strr=str.replaceAll(old, New);
		
		return strr;
	}
	
	
	public static String StringDecode(String str,String decode) throws UnsupportedEncodingException
	{
		return URLDecoder.decode(str, decode);
	}
}
