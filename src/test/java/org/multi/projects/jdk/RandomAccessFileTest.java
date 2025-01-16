package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileTest {

    private static final Logger log = LoggerFactory.getLogger(RandomAccessFileTest.class);

    @Test
    public void testRandomAccessFile() throws IOException {
        try  {
            RandomAccessFile access = new RandomAccessFile("access.txt", "rw");
            long filePointer = access.getFilePointer();
            System.out.printf("filePointer: %d%n", filePointer);

            FileDescriptor fd = access.getFD();
            System.out.println("fd: " + fd.toString());
            System.out.println("FD: " + access.getFD());

            access.writeInt(100);
            access.writeUTF("hello world");

            System.out.println("length: " + access.length());
            System.out.println("position: " + access.getFilePointer());

            // by using seek() method is to set the current file pointer
            // from where read/write could start i.e.
            // we set here 0 so reading will be done from 0 till EOF
            access.seek(0);
            int f = access.readInt();
            String s = access.readUTF();
            System.out.println("read:position: " + access.getFilePointer());
            System.out.println("readInt: " + f);
            System.out.println("readUTF: " + s);
            access.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void testChannel() {
        try {
            RandomAccessFile access = new RandomAccessFile("access.txt", "rw");
            FileChannel channel = access.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, access.length());
            buffer.putInt(1);
            String contents = "hello world";
            buffer.put(contents.getBytes(StandardCharsets.UTF_8));

            buffer.rewind();

            int anInt = buffer.getInt();
            System.out.println("anInt: " + anInt);
            byte[] bytes = new byte[contents.length()];
            buffer.get(bytes);
            System.out.println("bytes: " + new String(bytes, StandardCharsets.UTF_8));
            access.close();
            buffer.clear();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void testTransfer() throws IOException {
        RandomAccessFile access = new RandomAccessFile("access.txt", "rw");
        access.writeInt(1);
        access.writeUTF("hello world");
        FileChannel channel = access.getChannel();

        FileOutputStream out = new FileOutputStream("dst.txt");
        FileChannel dstChannel = out.getChannel();
        channel.transferTo(0, channel.size(), dstChannel);
        access.close();
    }
}
