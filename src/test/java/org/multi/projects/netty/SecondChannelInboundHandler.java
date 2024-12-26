package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class SecondChannelInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    protected void ensureNotSharable() {
        System.out.println("[2-in]ensureNotSharable");
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("[2-in]isSharable");
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]handlerAdded, channel: %s", ctx.channel()));
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]handlerRemoved, channel: %s", ctx.channel()));
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]channelRegistered, channel: %s", ctx.channel()));
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]channelUnregistered, channel: %s", ctx.channel()));
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]channelActive, channel: %s", ctx.channel()));
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]channelInactive, channel: %s", ctx.channel()));
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(String.format("[2-in]channelRead, channel: %s", ctx.channel()));
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            int v = buf.readInt();
            System.out.println(String.format("[2-in]channelRead, msg: %d", v));

            ByteBuf buf1 = Unpooled.directBuffer();
            buf1.writeInt(1000);
            ChannelFuture channelFuture = ctx.writeAndFlush(buf1);
       //     ctx.channel().writeAndFlush(buf1);
            channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {

                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("Data written successfully!");
                    } else {
                        System.out.println("Data write failed!");
                    }
                }
            });
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]channelReadComplete, channel: %s", ctx.channel()));
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(String.format("[2-in]userEventTriggered, channel: %s", ctx.channel()));
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("[2-in]channelWritabilityChanged, channel: %s", ctx.channel()));
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(String.format("[2-in]exceptionCaught, channel: %s", ctx.channel()));
        super.exceptionCaught(ctx, cause);
    }
}

