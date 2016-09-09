package me.kagami.NettyExample.guide;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * In this example, you will learn how to construct and send a message, and to
 * close the connection on completion.
 * 
 * @author Tian
 *
 */
public class MyTimeServerHandler extends ChannelInboundHandlerAdapter {
	// the channelActive() method will be invoked when a connection is
	// established and ready to generate traffic
	@Override
	public void channelActive(final ChannelHandlerContext ctx) { // (1)
//		final ByteBuf time = ctx.alloc().buffer(4); // 分配4字节buffer
//		time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
////		 A ChannelFuture represents an I/O operation which has not yet occurred.
//		final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//		//当写操作发生完毕后，会调用这里的回调接口。（因为Netty是异步的）
//		f.addListener(new ChannelFutureListener() {
//			public void operationComplete(ChannelFuture future) {
//				assert f == future;
//				ctx.close();
//			}
//		});
		
		
		//与TimeEncoder连起来看，这里先写入一个Bean，然后在TimeEncoder里编码，再发送到网络中去
		ChannelFuture f = ctx.writeAndFlush(new UnixTime());
		//或者调用预定义的listener
		f.addListener(ChannelFutureListener.CLOSE);
		System.out.println("MyTimeServerHandler");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
