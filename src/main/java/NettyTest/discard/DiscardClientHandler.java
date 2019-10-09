package NettyTest.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author hbs
 * @Date 2019/10/9
 */
public class DiscardClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try{
            cause.printStackTrace();
        }finally {
            ctx.close();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ((ByteBuf)msg).release();
    }
}
