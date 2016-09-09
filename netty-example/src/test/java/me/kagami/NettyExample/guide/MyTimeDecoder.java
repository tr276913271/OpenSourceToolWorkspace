package me.kagami.NettyExample.guide;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MyTimeDecoder extends ByteToMessageDecoder { // (1)
	// 内部会一直维护一个buffer，每当有新的数据到来，就会调用这个方法,当添加到out的时候，会释放这个buffer
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
		if (in.readableBytes() < 4) {
			// decode() can decide to add nothing to out where there is not
			// enough data in the cumulative buffer. ByteToMessageDecoder will
			// call decode() again when there is more data received.
			return;
		}

		// out.add(in.readBytes(4));
		out.add(new UnixTime(in.readUnsignedInt()));
	}

}
