package org.multi.projects.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ServerProcessorDemo extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        /**
         * ---------------------------------------------------
         *                    channel pipline
         * ---------------------------------------------------
         *      -----------------------  ----------------------
         *      channel handler context0  channel handler context1
         *      -----------------------  ------------------------
         *         channel handler0            channel handler1
         *
         * ---------------------------------------------------
         */
        ChannelPipeline pipeline = ch.pipeline();
        // inbound seq: 1 -> 2 -> 3
        pipeline.addLast(new FirstChannelInboundHandler());
        pipeline.addLast(new SecondChannelInboundHandler());
        pipeline.addLast(new ThreeChannelInboundHandler());

        //outbound seq: 1 -> 2 -> 3
        pipeline.addLast(new FirstChannelOutboundHandler());
        pipeline.addLast(new SecondChannelOutboundHandler());
        pipeline.addLast(new ThreeChannelOutboundHandler());
    }
}
