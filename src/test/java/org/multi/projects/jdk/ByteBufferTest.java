package org.multi.projects.jdk;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ByteBufferTest {

    @Test
    public void testByteBuffer() throws NoSuchFieldException, IllegalAccessException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);

        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());

        buffer = buffer.flip();
        byte b = buffer.get();
        System.out.println(b);

        buffer = buffer.rewind();
        buffer.put((byte) 3);
        buffer.put((byte) 4);
        System.out.println(buffer.position());
        System.out.println(buffer.position());

        IntBuffer intBuffer = IntBuffer.allocate(1024);
        intBuffer.put(1);
        intBuffer.flip();
        System.out.println(intBuffer.get());

        ByteBuf byteBuf = Unpooled.directBuffer(1024);
        byteBuf.writeByte(1);
        byteBuf.writeByte(2);

        System.out.println(byteBuf.readByte());
        byteBuf.release();
        buffer.clear();

        final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Object object = unsafeField.get(null);

        Unsafe unsafe = (Unsafe) object;
        System.out.println(unsafe);
        long aLong = unsafe.getLong(object, 0);
        System.out.println(aLong);
    }
}
