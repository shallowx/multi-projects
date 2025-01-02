package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class ClientInboundHandler extends ChannelInboundHandlerAdapter {

    private static final AttributeKey<String> ATTR_KEY = AttributeKey.valueOf("key");

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[1]channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[1]channelUnregistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        EventExecutor executor = ctx.channel().eventLoop();
        if (executor.inEventLoop()) {
            System.out.println("[1]channelActive");
            ByteBuf buf = Unpooled.directBuffer();
            buf.writeInt(100);
            ChannelPromise channelPromise = ctx.newPromise();
            channelPromise.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("[1]send success");
                        buf.release();
                    } else {
                        System.out.println("[1]send failed");
                    }
                }
            });
            ctx.channel().attr(ATTR_KEY).set(String.format("test-channel-attr, and address:%s", ctx.channel().remoteAddress()));
            ctx.writeAndFlush(buf.retain(), channelPromise);
        } else {
            executor.execute(() ->{
                System.out.println("[1]channelActive");
                ByteBuf buf = Unpooled.directBuffer();
                buf.writeInt(100);
                ChannelPromise channelPromise = ctx.newPromise();
                channelPromise.addListener(new GenericFutureListener<Future<? super Void>>() {
                    @Override
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        if (future.isSuccess()) {
                            System.out.println("[1]send success");
                            buf.release();
                        } else {
                            System.out.println("[1]send failed");
                        }
                    }
                });
                ctx.channel().attr(ATTR_KEY).set(String.format("test-channel-attr, and address:%s", ctx.channel().remoteAddress()));
                ctx.writeAndFlush(buf.retain(), channelPromise);
            });
        }
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("[1]channelRead");
        String kv = ctx.channel().attr(ATTR_KEY).get();
        System.out.printf("[1]channelRead, attr-key:%s%n", kv);
        if (msg instanceof ByteBuf) {
            ByteBuf buf =  (ByteBuf) msg;
            int v = buf.readInt();
            System.out.println("[1]read bytes " + v);
            buf.release();
        } else {
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[1]channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("[1]userEventTriggered");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[1]channelWritabilityChanged");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("[1]ensureNotSharable");
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("[1]isSharable");
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[1]handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[1]handlerRemoved");
        super.handlerRemoved(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("[1]exceptionCaught");
        super.exceptionCaught(ctx, cause);
    }
}
