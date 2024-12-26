package org.multi.projects.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.MultiThreadIoEventLoopGroup;
import io.netty.channel.nio.NioIoHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class ClientDemo {
    public static void main(String[] args) throws InterruptedException {
        MultiThreadIoEventLoopGroup group = new MultiThreadIoEventLoopGroup(NioIoHandler.newFactory());
        try {
           Bootstrap bootstrap = new Bootstrap();
           bootstrap.group(group);
           bootstrap.channel(NioSocketChannel.class);
           bootstrap.handler(new ChannelInitializer<SocketChannel>() {
               @Override
               protected void initChannel(SocketChannel channel) throws Exception {
                   ChannelPipeline pipeline = channel.pipeline();
                   pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
                   pipeline.addLast(new ClientInboundHandler());
               }
           });

           bootstrap.connect("127.0.0.1", 8888).addListener(new GenericFutureListener<Future<? super Void>>() {

               @Override
               public void operationComplete(Future<? super Void> future) throws Exception {
                   if (future.isSuccess()) {
                       System.out.println("Client connected");
                   } else {
                       System.out.println("Client disconnected");
                   }
               }
           }).sync().channel().closeFuture().sync();
       } finally {
            group.shutdownGracefully();
        }
    }
}
