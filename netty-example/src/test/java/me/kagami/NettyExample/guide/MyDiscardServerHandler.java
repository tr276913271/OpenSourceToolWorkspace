package me.kagami.NettyExample.guide;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class MyDiscardServerHandler extends ChannelInboundHandlerAdapter {
	/**
	 *  This method is called with the received message, whenever new data is received from a client. 
	 *  In this example, the type of the received message is ByteBuf.
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// Discard the received data silently.
		/** 需要牢记，msg需要手动释放资源
		 *  ByteBuf is a reference-counted object which has to be released explicitly via the release() method. 
		 *  Please keep in mind that it is the handler's responsibility to release any reference-counted object passed to the handler. 
		 */
//        ((ByteBuf) msg).release(); // (3)
        
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		 // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
	}
	
}
