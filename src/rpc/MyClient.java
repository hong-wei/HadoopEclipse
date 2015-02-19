package rpc;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class MyClient {
	public static void main(String[] args) throws Exception {
		//构造一个客户端得代理对象
		final MyBizable proxy = (MyBizable)RPC.waitForProxy(MyBizable.class, 
				MyBizable.VERSION, 
				new InetSocketAddress(MyServer.SERVER_ADDRESS, MyServer.SERVER_PORT), 
				new Configuration());
		//调用接口中的方法
		final String result = proxy.hello("world"); 
		System.out.println("客户端调用结果："+result); //本质是关闭网络连接
		
		RPC.stopProxy(proxy);
		
	} 
	
}


