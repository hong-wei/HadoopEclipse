package rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBizable extends VersionedProtocol{
	public static final long VERSION = 2345234L;
	public abstract String hello(String name);
	}