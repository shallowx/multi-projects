package org.multi.projects;

import org.junit.jupiter.api.Test;

/**
 * The BitsTests class contains various JUnit tests for bit manipulation operations.
 */
public class BitsTests {
    /**
     * Tests the different bitwise operations on an integer.
     *
     * This method demonstrates setting, clearing, and toggling bits of an integer
     * and prints the binary representation of the integer at each step.
     *
     * Operations performed:
     * - Setting a specific bit
     * - Clearing a specific bit
     * - Toggling a specific bit
     *
     * Note: The method includes print statements that show the state of the integer
     * in binary format after each operation.
     */
    @Test
    public void test() {
        int num = 5;
        System.out.println(String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
        // setting bits
        num |= (1 << 1);
        System.out.println(String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));

        // clear bits
        num &= ~(1 << 1);
        System.out.println(String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));

        // change bits
        num |= (1 << 1);
        num ^= (1 << 1);
        System.out.println(String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
    }
    
    /**
     * Tests the binary representation of a long integer by printing its
     * 64-bit binary form.
     *
     * This method takes a hardcoded long number (5 in this case), converts
     * it to its 64-bit binary representation, and prints the length of the
     * binary string followed by the binary string itself in reverse order.
     *
     * It demonstrates the bitwise right shift operation and bitwise AND
     * to extract each bit of the number.
     */
    @Test
    public void testPrintBinary() {
        long num = 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 63; i++) {
            sb.append((num >> i) & 1);
        }
        System.out.println(sb.length());
        System.out.println(sb.reverse());
    }

    /**
     * Tests the counting of bits in an integer's binary representation.
     *
     * The method demonstrates two different techniques for counting the number
     * of '1' bits (also known as Hamming weight or population count) in the
     * binary representation of an integer.
     *
     * The first approach uses a for-loop to shift the bits of the integer
     * to the right and count the number of '1' bits.
     *
     * The second approach uses a while-loop to shift the bits to the right
     * until the integer becomes zero and counts the number of '1' bits.
     *
     * Note: The method prints the count of bits for both approaches.
     */
    @Test
    public void testCountBits() {
        int num = 5;
        int count = 0;
        for (int i = 0; i <= 31 ; i++) {
            count += (num >> i) & 1;
        }
        System.out.println(count);

        count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        System.out.println(count);
    }


    // num & ((~num) + 1)  get the right value is '1'
    @Test
    public void testCountBits01() {
        int num = 5;
        int count = 0;
        while (num != 0) {
            int n = num & ((~num) + 1);
            count++;
            num ^= n;
        }
        System.out.println(count);
    }

    /**
     * Tests the least significant bit (LSB) operation on an integer.
     *
     * This method identifies the position of the lowest set bit (LSB) in an
     * integer, then toggles this bit, and prints the modified integer.
     *
     * The process involves:
     * - Shifting the bits of the integer to the right until the LSB is found.
     * - Toggling the found bit using the XOR operation.
     * - Printing the integer after the bit has been toggled.
     */
    @Test
    public void testLSB() {
        int num = 5;
        int pos = 0;
        while ((num >> pos & 1) == 0) {
            pos++;
        }
        num = num ^ (1 << pos);
        System.out.println(num);
    }

    /**
     * Tests the addition of two binary strings.
     *
     * This method demonstrates adding two binary strings and
     * printing the resulting sum. It utilizes the `addBitStrings` method
     * to perform the actual addition by converting the strings to
     * StringBuilder objects and then summing them bit by bit.
     *
     * The method includes print statements that show the resulting sum.
     */
    @Test
    public void testAddBitStrings() {
        String str1 = "1100011";
        String str2 = "10";
        System.out.println("Sum is " + addBitStrings(new StringBuilder(str1), new StringBuilder(str2)));
    }

    /**
     * Ensures two StringBuilder objects have equal length by padding the shorter one with leading zeros.
     *
     * @param str1 the first StringBuilder object
     * @param str2 the second StringBuilder object
     * @return the new length of both StringBuilder objects after equalizing their lengths
     */
    static int makeEqualLength(StringBuilder str1, StringBuilder str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++)
                str1.insert(0, '0');
            return len2;
        } else if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++)
                str2.insert(0, '0');
        }
        return len1;
    }

    /**
     * Adds two binary strings represented by StringBuilder objects
     * and returns their sum as a binary string.
     *
     * @param str1 the first binary string represented as a StringBuilder
     * @param str2 the second binary string represented as a StringBuilder
     * @return the resulting binary string after adding the two input binary strings
     */
    String addBitStrings(StringBuilder str1, StringBuilder str2) {
        StringBuilder result = new StringBuilder();
        int length = makeEqualLength(str1, str2);

        String first = str1.toString();
        String second = str2.toString();

        int carry = 0;

        for (int i = length - 1; i >= 0; i--) {
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            int sum = (firstBit ^ secondBit ^ carry) + '0';

            result.insert(0, (char) sum);
            carry = (firstBit & secondBit) |
                    (secondBit & carry) |
                    (firstBit & carry);
        }

        if (carry == 1){
            result.insert(0, "1");
        }
        return result.toString();
    }
}
