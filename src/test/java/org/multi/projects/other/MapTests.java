package org.multi.projects.other;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * The MapTests class provides unit tests for different map implementations in Java,
 * including IdentityHashMap, HashMap, and WeakHashMap.
 */
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

    /**
     * Tests the behavior of the HashMap class in Java.
     * Demonstrates how HashMap handles elements with equal hash codes,
     * null keys, and null values.
     *
     * The method performs the following operations:
     * - Adds two instances of TestMap with equal content to the map.
     * - Adds a null key with a non-null value.
     * - Adds a non-null key with a null value.
     * - Prints the map to the console to display its contents.
     */
    @Test
    public void TestHashMap() {
        Map<Object, Object> map = new HashMap<>();
        map.put(new TestMap("A", 1), "A");
        map.put(new TestMap("A", 1), "A");
        map.put(null,"A");
        map.put("A", null);
        System.out.println(map);
    }

    /**
     * This method tests the behavior of a WeakHashMap using custom objects as keys.
     * It performs the following actions:
     * - Creates a WeakHashMap instance.
     * - Adds several key-value pairs, including keys that are instances of the TestMap class
     *   with identical values but as separate objects, a null key, and a null value.
     * - Prints the contents of the WeakHashMap to the console.
     *
     * The expected behavior is that the WeakHashMap allows null keys and values,
     * and treats different instances of TestMap with identical values as separate keys.
     */
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
        /**
         * The name of the TestMap instance.
         */
        private final String name;
        /**
         * Represents the age of an individual.
         * This field is immutable and initialized via the constructor.
         */
        private final int age;

        /**
         * Constructs a new TestMap instance with the specified name and age.
         *
         * @param name the name associated with this TestMap instance
         * @param age  the age associated with this TestMap instance
         */
        public TestMap(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * Compares this object to the specified object. The result is true if and only if
         * the argument is not null and is a TestMap object that has the same name and age
         * as this object.
         *
         * @param o the object to compare this TestMap against
         * @return true if the given object represents a TestMap equivalent to this TestMap, false otherwise
         */
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
