package org.multi.projects.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

public class SecondChannelOutboundHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println(String.format("[2]bind, channel: %s, local-address:%s", ctx.channel(), localAddress.toString()));
        super.bind(ctx, localAddress, promise);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println(String.format("[2]connect, channel: %s, local-address:%s, remote-address:%s", ctx.channel(), localAddress.toString(), remoteAddress.toString()));
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(String.format("[2]disconnect, channel: %s", ctx.channel()));
        super.disconnect(ctx, promise);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(String.format("[2]close, channel: %s", ctx.channel()));
        super.close(ctx, promise);
    }

    @Override
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(String.format("[2]deregister, channel: %s", ctx.channel()));
        super.deregister(ctx, promise);
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2]read, channel: %s", ctx.channel()));
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(String.format("[2]write, channel: %s", ctx.channel()));
        super.write(ctx, msg, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2]flush, channel: %s", ctx.channel()));
        super.flush(ctx);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("[2]ensureNotSharable");
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("[2]isSharable");
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2]handlerAdded, channel: %s", ctx.channel()));
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2]handlerRemoved, channel: %s", ctx.channel()));
        super.handlerRemoved(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(String.format("[2]exceptionCaught, channel: %s", ctx.channel()));
        super.exceptionCaught(ctx, cause);
    }
}
