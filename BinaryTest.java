package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary value
     */
    @Test
    public void normalConstructor()
    {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with a zero-tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with a binary number and zero
     */
    @Test
    public void add4()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    // New Tests for OR function
    @Test
    public void orBasic()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0101");
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("1111"));
    }

    @Test
    public void orDifferentLengths()
    {
        Binary binary1 = new Binary("110");
        Binary binary2 = new Binary("10010");
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("10110"));
    }

    @Test
    public void orAllZeros()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    // New Tests for AND function
    @Test
    public void andBasic()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0101");
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    @Test
    public void andDifferentLengths()
    {
        Binary binary1 = new Binary("110");
        Binary binary2 = new Binary("10010");
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("10"));
    }

    @Test
    public void andAllZeros()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    // New Tests for Multiply function
    @Test
    public void multiplyBasic()
    {
        Binary binary1 = new Binary("10");  // 2 in decimal
        Binary binary2 = new Binary("11"); // 3 in decimal
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("110")); // 6 in decimal
    }

    @Test
    public void multiplyWithZero()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010"); // 10 in decimal
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    @Test
    public void multiplyDifferentLengths()
    {
        Binary binary1 = new Binary("101");  // 5 in decimal
        Binary binary2 = new Binary("11");   // 3 in decimal
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("1111")); // 15 in decimal
    }
}
