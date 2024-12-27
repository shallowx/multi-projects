package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ThreeChannelInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    protected void ensureNotSharable() {
        System.out.println("[3-in]ensureNotSharable");
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("[3-in]isSharable");
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]handlerAdded, channel: %s%n", ctx.channel());
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]handlerRemoved, channel: %s%n", ctx.channel());
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]channelRegistered, channel: %s%n", ctx.channel());
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]channelUnregistered, channel: %s%n", ctx.channel());
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]channelActive, channel: %s%n", ctx.channel());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]channelInactive, channel: %s%n", ctx.channel());
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]channelReadComplete, channel: %s%n", ctx.channel());
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.printf("[3-in]userEventTriggered, channel: %s%n", ctx.channel());
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[3-in]channelWritabilityChanged, channel: %s%n", ctx.channel());
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.printf("[3-in]exceptionCaught, channel: %s%n", ctx.channel());
        System.out.printf("[3-in]exceptionCaught, cause: %s%n", cause.getMessage());
    }
}

