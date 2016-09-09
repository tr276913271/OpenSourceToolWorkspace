package me.kagami.NettyExample.guide;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyTimeClientHandler extends ChannelInboundHandlerAdapter {

	// Netty will call the channelRead() method again when more data arrives。
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// ByteBuf m = (ByteBuf) msg; // (1)
		// try {
		// long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
		// System.out.println(new Date(currentTimeMillis));
		// ctx.close();
		// } finally {
		// m.release();
		// }
		
		//这里使用POJO的方式处理消息
		UnixTime m = (UnixTime) msg;
		System.out.println(m);
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
