package me.kagami.NettyExample.file;

import org.junit.Test;

import io.netty.example.file.FileServer;
/**
 * 这个例子的功能是显示本机上的文件内容
 */
public class FileRun {
	@Test
	public void test() {
		try {
			//这个例子中用到了以下ChannelHandler
			//StringEncoder，StringDecoder :负责字符串到字节的编码解码
			//LineBasedFrameDecoder:负责处理接收字节最大长度
			//ChunkedWriteHandler:负责大文件，大数据读写，配合 ChunkedFile类使用，具体看说明;
			FileServer.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
