package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import org.junit.jupiter.api.Test;

public class PoolAllocByteBufTest {

    @Test
    public void testPoolAllocByteBuf() {
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        ByteBuf byteBuf = allocator.directBuffer(0, 1024);
        byteBuf.writeInt(1);
        byteBuf.writeInt(2);
        byteBuf.writeInt(3);

        System.out.println(byteBuf.readInt());
        byteBuf.skipBytes(4);
        System.out.println(byteBuf.readInt());

        byteBuf.release();
    }
}
