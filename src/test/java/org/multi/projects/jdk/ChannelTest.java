package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelTest {

    @Test
    public void testFileChannel() throws IOException {
        try (RandomAccessFile randomAccess = new RandomAccessFile("test.txt", "rw");) {
            FileChannel fileChannel = randomAccess.getChannel();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4 * 1024);
            byte[] bytes = "hello world".getBytes(StandardCharsets.UTF_8);
            mappedByteBuffer.put(bytes);

            mappedByteBuffer.flip();
            byte[] readBytes = new byte[bytes.length];
            while (mappedByteBuffer.hasRemaining()) {
                mappedByteBuffer.get(readBytes);
            }
            System.out.printf("buffer read: %s%n", new String(readBytes, StandardCharsets.UTF_8));
        } catch (Exception ignored) {}
    }
}
