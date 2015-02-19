package hdfs;



import java.io.FileInputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
public class App2 {
	public static final String HDFS_PATH = "hdfs://master:9000";
	public static final String DIR_PATH = "/777";
	public static final String FILE_PATH = "/hello";
	private static String path_src = "/Users/zhanghongwei/Documents/workspace/HadoopEclipse/src/shenma.txt";
	
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		final FileSystem fileSystem = FileSystem.get(new URI(HDFS_PATH),new Configuration());
		// create the folder
//		fileSystem.mkdirs(new Path(DIR_PATH));
		
		// upload the file
		final FSDataOutputStream out = fileSystem.create(new Path(FILE_PATH));
		final FileInputStream in = new FileInputStream (path_src);
		IOUtils.copyBytes(in, out, 1024,true);
//		
//		// download the file
		final FSDataInputStream in_download = fileSystem.open(new Path(FILE_PATH));
		IOUtils.copyBytes(in_download, System.out, 1024,true);
//		
//		// delete the file
//		fileSystem.delete(new Path(FILE_PATH),true);

	}

}
