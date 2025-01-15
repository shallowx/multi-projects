package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.CountDownLatch;

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
        System.out.printf("[2-in]handlerAdded, channel: %s%n", ctx.channel());
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]handlerRemoved, channel: %s%n", ctx.channel());
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]channelRegistered, channel: %s%n", ctx.channel());
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]channelUnregistered, channel: %s%n", ctx.channel());
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]channelActive, channel: %s%n", ctx.channel());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]channelInactive, channel: %s%n", ctx.channel());
        super.channelInactive(ctx);
    }

    CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        EventLoop eventLoop = ctx.channel().eventLoop();
        if (eventLoop.inEventLoop()) {
            //for test
            eventLoop.execute(() -> {
                System.out.printf("[2-in]channelRead, channel: %s%n", ctx.channel());
                if (msg instanceof ByteBuf) {
                    ByteBuf buf = ((ByteBuf) msg).retain();
                    int v = buf.readInt();
                    System.out.printf("[2-in]channelRead, msg: %d%n", v);
                    buf.release();

                    ByteBuf buf1 = Unpooled.directBuffer();
                    buf1.writeInt(1000);

                    // inbound execute by sequence  and outbound execute by reverse
                    // what are the difference between '[1]ctx.writeAndFlush' and '[2]channel.writeAndFlush':
                    // 1. pipline includes head and tail about the difference of the ctx and channel
                    // 2. 'ctx.writeAndFlush' find bound handler from current node to pre,such as pipline includes inbound(1 -> 2 -> 3) and outbound (1 -> 2 -> 3),
                    // and 'ctx.writeAndFlush' execute in 2, so find the 1 is matched outbound, so 'ctx.writeAndFlush' if in the inbound handler will not execute the outbound methods
                    // and 'ctx.writeAndFlush' execute in outbound 2, and it will execute outbound 1 but not execute outbound 3
                    // 3. 'channel.writeAndFlush' anywhere execute that find the outbound from the tail outbound, so all outbounds will execute

                    // ChannelFuture channelFuture = ctx.writeAndFlush(buf1);
                    ChannelFuture channelFuture = ctx.channel().writeAndFlush(buf1);
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
                    latch.countDown();
                }
            });
        } else {
            eventLoop.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("[2-in]channelRead, channel: %s%n", ctx.channel());
                    if (msg instanceof ByteBuf) {
                        ByteBuf buf = ((ByteBuf) msg).retain();
                        int v = buf.readInt();
                        System.out.printf("[2-in]channelRead, msg: %d%n", v);
                        buf.release();

                        ByteBuf buf1 = Unpooled.directBuffer();
                        buf1.writeInt(1000);

                        // inbound execute by sequence  and outbound execute by reverse
                        // what are the difference between '[1]ctx.writeAndFlush' and '[2]channel.writeAndFlush':
                        // 1. pipline includes head and tail about the difference of the ctx and channel
                        // 2. 'ctx.writeAndFlush' find bound handler from current node to pre,such as pipline includes inbound(1 -> 2 -> 3) and outbound (1 -> 2 -> 3),
                        // and 'ctx.writeAndFlush' execute in 2, so find the 1 is matched outbound, so 'ctx.writeAndFlush' if in the inbound handler will not execute the outbound methods
                        // and 'ctx.writeAndFlush' execute in outbound 2, and it will execute outbound 1 but not execute outbound 3
                        // 3. 'channel.writeAndFlush' anywhere execute that find the outbound from the tail outbound, so all outbounds will execute

                        // ChannelFuture channelFuture = ctx.writeAndFlush(buf1);
                        ChannelFuture channelFuture = ctx.channel().writeAndFlush(buf1);
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
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]channelReadComplete, channel: %s%n", ctx.channel());
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.printf("[2-in]userEventTriggered, channel: %s%n", ctx.channel());
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("[2-in]channelWritabilityChanged, channel: %s%n", ctx.channel());
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.printf("[2-in]exceptionCaught, channel: %s%n", ctx.channel());
        super.exceptionCaught(ctx, cause);
    }
}

