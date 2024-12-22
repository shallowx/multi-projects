package org.multi.projects.netty;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCounted;
import org.junit.jupiter.api.Test;

public class ReferenceCountedTest {
    @Test
    public void testReferenceCounted() {
        Message message = Message.newMessagePacker(200);
        System.out.println(message.refCnt());
        System.out.println(message.retain());
        System.out.println(message.refCnt());
        message.release();
        System.out.println(message.refCnt());
        message.release();
    }

    private static class Message extends AbstractReferenceCounted {
        private final Recycler.Handle<Message> recycleHandle;
        private static final Recycler<Message> RECYCLER = new Recycler<>() {
            @Override
            protected Message newObject(Handle<Message> handle) {
                return new Message(handle);
            }
        };
        public Message(Recycler.Handle<Message> recycleHandle) {
            this.recycleHandle = recycleHandle;
        }

        private int code;
        public static Message newMessagePacker(int code) {
            final Message message = RECYCLER.get();
            message.setRefCnt(1);
            message.code = code;
            return message;
        }

        public int getCode() {
            return code;
        }

        @Override
        public ReferenceCounted retain() {
            super.retain();
            return this;
        }

        @Override
        public ReferenceCounted retain(int increment) {
            super.retain(increment);
            return this;
        }

        @Override
        protected void deallocate() {
            recycleHandle.recycle(this);
        }

        @Override
        public ReferenceCounted touch(Object o) {
            return this;
        }
    }
}
