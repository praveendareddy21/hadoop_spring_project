package example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;


public class HadoopFSConnection{
	public static void main(String... arg) {

		try {
			    Configuration conf = new Configuration();
			    FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.99.100:9000"),conf);
			    if(fileSystem instanceof DistributedFileSystem) {
			      System.out.println("HDFS is the underlying filesystem");
			    }
			    else {
			      System.out.println("Other type of file system "+fileSystem.getClass());
			    }
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (URISyntaxException  e) {
			e.printStackTrace();
			System.exit(1);
		}


	}

}
