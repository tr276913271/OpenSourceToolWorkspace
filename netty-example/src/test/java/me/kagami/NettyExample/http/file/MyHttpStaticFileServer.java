package me.kagami.NettyExample.http.file;

import org.junit.Test;

import io.netty.example.http.file.HttpStaticFileServer;
/**
 * 会显示server所在目录下的文件。类似ftp的显示方式，运行后访问http://127.0.0.1:8080/
 * @author Tian
 *
 */
public class MyHttpStaticFileServer {
	@Test
	public void test() {
		try {
			HttpStaticFileServer.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
