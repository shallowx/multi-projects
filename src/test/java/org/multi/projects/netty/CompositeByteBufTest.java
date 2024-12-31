package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

public class CompositeByteBufTest {

    @Test
    public void testCompositeByteBuf() {
        CompositeByteBuf compositeByteBuf = ByteBufAllocator.DEFAULT.compositeDirectBuffer(Integer.MAX_VALUE);
        ByteBuf byteBuf = Unpooled.directBuffer();
        byteBuf.writeByte(1);
        byteBuf.writeByte(2);
        byteBuf.writeByte(3);
        byteBuf.writeByte(4);

        ByteBuf byteBuf1 = Unpooled.directBuffer();
        byteBuf1.writeByte(11);
        byteBuf1.writeByte(22);
        byteBuf1.writeByte(33);
        byteBuf1.writeByte(44);

        compositeByteBuf.addFlattenedComponents(true, byteBuf);
        compositeByteBuf.addFlattenedComponents(true, byteBuf1);

        System.out.println(compositeByteBuf.toString());
        System.out.println(compositeByteBuf.readerIndex());
        System.out.println(compositeByteBuf.writerIndex());
        System.out.println(compositeByteBuf.capacity());
        System.out.println(compositeByteBuf.maxCapacity());

        System.out.println(compositeByteBuf.readByte());
        compositeByteBuf.skipBytes(3);
        System.out.println(compositeByteBuf.readByte());

        compositeByteBuf.release();
    }
}
