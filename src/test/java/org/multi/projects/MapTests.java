package org.multi.projects;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MapTests {

    @Test
    public void testIdentityMap() {
        IdentityHashMap<Object, Object> refEuqals = new IdentityHashMap<>();
        TestMap o1 = new TestMap("A", 1);
        TestMap o2 = new TestMap("A", 1);
        refEuqals.put(o1, "A");
        refEuqals.put(o2, "A");
        refEuqals.put(null,"A");
        TestMap o3 = o1;

        // use the default method hashcode, and return the object memory address
        System.out.println(System.identityHashCode(o1));
        System.out.println(System.identityHashCode(o2));
        System.out.println(System.identityHashCode(o3));

        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o3.hashCode());

        System.out.println(refEuqals.get(o3));
    }

    @Test
    public void TestHashMap() {
        Map<Object, Object> map = new HashMap<>();
        map.put(new TestMap("A", 1), "A");
        map.put(new TestMap("A", 1), "A");
        map.put(null,"A");
        map.put("A", null);
        System.out.println(map);
    }

    @Test
    public void TestWeakHashMap() {
        WeakHashMap<Object, Object> weakMap = new WeakHashMap<>();
        weakMap.put(new TestMap("A", 1), "A");
        weakMap.put(new TestMap("A", 1), "A");
        weakMap.put(null,"A");
        weakMap.put("A", null);
        System.out.println(weakMap);
    }

    static class TestMap {
        private final String name;
        private final int age;

        public TestMap(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestMap that = (TestMap) o;
            return age == that.age && Objects.equals(name, that.name);
        }

        // in other words, if not override the default method hashcode, and will return the object memory address
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
