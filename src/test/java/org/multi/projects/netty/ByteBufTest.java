package org.multi.projects.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class ByteBufTest {

    @Test
    public void testByteBuf0() {
        ByteBuf buf = Unpooled.directBuffer(1024, 1024);
        System.out.println(buf.capacity());
        System.out.println(buf.readableBytes());
        System.out.println(buf.writableBytes());
        System.out.println(buf.refCnt());
        System.out.println(buf.maxCapacity());

        System.out.println("-".repeat(20));

        buf.writeInt(100);
        buf.writeBytes("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println(buf.capacity());
        System.out.println(buf.readableBytes());
        System.out.println(buf.writableBytes());
        System.out.println(buf.refCnt());
        System.out.println(buf.maxCapacity());

        System.out.println("-".repeat(20));

        int numbers = buf.readInt();
        System.out.println(numbers);
        byte[] bytes = new byte[5];
        buf.readBytes(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        System.out.println("-".repeat(20));
        System.out.println(buf.readableBytes());
        System.out.println(buf.capacity());
        System.out.println(buf.writableBytes());
        System.out.println(buf.maxCapacity());
    }

    @Test
    public void testByteBuf1() {
        ByteBuf buf = Unpooled.directBuffer(1024, 1024);
        buf.writeInt(100);
        buf.writeBytes("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println("-".repeat(20));

        ByteBuf duplicateBuf = buf.duplicate();
        System.out.println(duplicateBuf.readableBytes());
        System.out.println(duplicateBuf.capacity());
        System.out.println(duplicateBuf.writableBytes());
        System.out.println(duplicateBuf.refCnt());

        System.out.println("-".repeat(20));

        duplicateBuf.writeInt(1000);
        System.out.println(buf.readableBytes());
        System.out.println(buf.writableBytes());

        System.out.println("-".repeat(20));
        System.out.println(duplicateBuf.readableBytes());
        System.out.println(duplicateBuf.writableBytes());

        System.out.println(buf.readableBytes());
        System.out.println(buf.writableBytes());

        duplicateBuf.skipBytes(9);
        System.out.println(duplicateBuf.readInt());
        buf.release();
    }

    @Test
    public void testByteBuf2() {
        ByteBuf buf = Unpooled.directBuffer(1024, 1024);
        buf.writeInt(100);
        buf.writeBytes("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println("-".repeat(20));

        ByteBuf sliceBuf = buf.slice(0, 9);
        System.out.println(sliceBuf.readableBytes());
        System.out.println(sliceBuf.capacity());
        System.out.println(sliceBuf.writableBytes());
        System.out.println(sliceBuf.refCnt());
        System.out.println(buf.refCnt());
        System.out.println("-".repeat(20));
    }

    @Test
    public void testByteBuf3() {
        ByteBuf buf = Unpooled.directBuffer(1024, 1024);
        buf.writeInt(100);
        buf.writeBytes("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println("-".repeat(20));

        System.out.println(buf.refCnt());
        transferByteBuf(buf.retain());
        buf.release();
    }

    private void transferByteBuf(ByteBuf buf) {
        int count = buf.readableBytes();
        if (count > 0) {
            int v = buf.readInt();
            System.out.println(v);
        }
        System.out.println("-".repeat(20));
        System.out.println(buf.refCnt());
        buf.release();
        System.out.println(buf.refCnt());
    }

    @Test
    public void testByteBuf4() {
        ByteBuf buf = Unpooled.directBuffer(1024, 1024);
        ByteBuf duplicate = buf.duplicate();

        duplicate.writeInt(100);
        System.out.println(duplicate.readInt());

        buf.writeInt(1000);
        System.out.println(buf.readInt());
    }

    @Test
    public void testByteBuf5() {
        ByteBuf buf = Unpooled.directBuffer(1024, 1024);
        buf.writeInt(100);

        ByteBuf slice = buf.readSlice(4);
        slice.resetWriterIndex();
        System.out.println(slice.readableBytes());
        System.out.println(slice.capacity());
        System.out.println(slice.maxCapacity());

        slice.writeInt(100);
        System.out.println(slice.readInt());
        System.out.println(slice.readerIndex());
        System.out.println(slice.writerIndex());

        System.out.println("-".repeat(20));

        buf.writeInt(1000);
        System.out.println(buf.readInt());
    }
}
