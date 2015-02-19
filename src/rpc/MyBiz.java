package rpc;

import java.io.IOException;

public class MyBiz implements MyBizable{
	
	@Override
	public String hello(String name){
		System.out.println("!!!!!I am super man");
		return "hello "+name; 
	}
	
	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException { 
		return MyBizable.VERSION;
	} 
	
}
