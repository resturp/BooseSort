/*
Copyright 2018 Thomas Boose

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in 
the Software without restriction, including without limitation the rights to 
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of 
the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all 
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS 
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.frii.boosesort.tests;

import java.util.Random;
import nl.frii.boosesort.Binteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import nl.frii.boosesort.BooseSort;
import nl.frii.boosesort.MergeSort;
import org.junit.Assert;

/**
 *
 * @author thomas
 */
public class SortTest {

    public SortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestEmptyArray() {
        Integer[] leeg = new Integer[0];
        Assert.assertArrayEquals("Empty in should return empty out.", BooseSort.sort(leeg), leeg);
        Assert.assertArrayEquals("Merge: Empty in should return empty out.", MergeSort.sort(leeg), leeg);
    }

    @Test
    public void TestSingleItemArray() {
        Integer[] single = {0};
        Assert.assertArrayEquals("Single in should return same single out.", BooseSort.sort(single), single);
        Assert.assertArrayEquals("Merge: Single in should return same single out.", MergeSort.sort(single), single);
    }

    @Test
    public void TestTwoItemsSortedArray() {
        Integer[] twoInts = {0, 2};
        Integer[] twoIntsOut = {0, 2};
        Assert.assertArrayEquals("These two items were sorted going in.", BooseSort.sort(twoInts), twoInts);
    }

    @Test
    public void TestTwoItemsNotSortedArray() {
        Integer[] twoInts = {6, 0};
        Integer[] twoIntsOut = {0, 6};

        Assert.assertArrayEquals("These two items should have switched.", BooseSort.sort(twoInts), twoIntsOut);
    }

    @Test
    public void TestEightItemsNotSortedArray() {
        Integer[] eightInts = {0, 6, 3, 5, 9, 1, 1, 5};
        Integer[] eightIntsOut = {0, 1, 1, 3, 5, 5, 6, 9};

        Assert.assertArrayEquals("Single in should return same single out.", BooseSort.sort(eightInts), eightIntsOut);
    }

    @Test
    public void TestSevenItemsNotSortedArray() {
        Integer[] sevenInts = {0, 6, 3, 9, 1, 1, 5};
        Integer[] sevenIntsOut = {0, 1, 1, 3, 5, 6, 9};

        Assert.assertArrayEquals("Single in should return same single out.", BooseSort.sort(sevenInts), sevenIntsOut);
    }

    @Test
    public void TestFiveItemsNotSortedArray() {
        Integer[] fiveInts = {0, 6, 3, 9, 1};
        Integer[] fiveIntsOut = {0, 1, 3, 6, 9};

        Assert.assertArrayEquals("These five should return sorted array.", BooseSort.sort(fiveInts), fiveIntsOut);
    }

    @Test
    public void TestFiveItemsNotSortedArrayLastGoesFirst() {
        Integer[] fiveInts = {9, 6, 3, 1, 0};
        Integer[] fiveIntsOut = {0, 1, 3, 6, 9};

        Assert.assertArrayEquals("These five should return sorted array.", BooseSort.sort(fiveInts), fiveIntsOut);
    }

    @Test
    public void TestFiveItemsNotSortedArrayLastGoesLast() {
        Integer[] fiveInts = {3, 6, 0, 1, 9};
        Integer[] fiveIntsOut = {0, 1, 3, 6, 9};

        Assert.assertArrayEquals("These five should return sorted array.", BooseSort.sort(fiveInts), fiveIntsOut);
    }

    @Test
    public void TestFiftyThousandItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 50 K --");
        TestNItemsNotSorted(50000);
    }

    @Test
    public void TestFiveMilionItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 5 mil --");
        TestNItemsNotSorted(5000000);
    }

    @Test
    public void TestTenMilionItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 10 mil --");
        TestNItemsNotSorted(10000000);
    }

    @Test
    public void TesteightItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 8 --");
        TestNItemsNotSorted(8);
    }

    @Test
    public void TestSevenItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 7 --");
        TestNItemsNotSorted(7);
    }

    @Test
    public void TestSixteenItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 16 --");
        TestNItemsNotSorted(16);
    }

    @Test
    public void TestSeventeenItemsNotSortedArrayLastGoesLast() {
        System.out.println("-- 17 --");
        TestNItemsNotSorted(17);
    }

    public void TestNItemsNotSorted(int number) {
        Random rand = new Random(System.currentTimeMillis());

        Binteger[] EnIntsBoose = new Binteger[number];
        Binteger[] EnIntsMerge = new Binteger[number];
        Binteger[] EnIntsOrg = new Binteger[number];
        
        Comparable[] EnIntsOut = new Comparable[number];

        for (int i = 0; i < number; i++) {
            EnIntsBoose[i] = new Binteger(rand.nextInt());
            EnIntsMerge[i] = new Binteger(EnIntsBoose[i].getValue());
            EnIntsOrg[i] = new Binteger(EnIntsBoose[i].getValue());
        }

        EnIntsOut = BooseSort.sort(EnIntsOrg);
        long startTime, endTime;
        
        Binteger.numberOfCompares = 0;
        startTime = System.nanoTime();
        Assert.assertArrayEquals("These " + number + " items should return sorted array.", BooseSort.sort(EnIntsBoose), EnIntsOut);
        endTime = System.nanoTime();

        System.out.println("After BooseSort " + Binteger.numberOfCompares + " compares.");
        System.out.println("Boose sort took: " + (endTime - startTime) / 1000000 + "ms");

        Binteger.numberOfCompares = 0;
        startTime = System.nanoTime();
        Assert.assertArrayEquals("Merge: These " + number + " items should return sorted array.", MergeSort.sort(EnIntsMerge), EnIntsOut);
        endTime = System.nanoTime();

        System.out.println("After MergeSort " + Binteger.numberOfCompares + " compares.");
        System.out.println("Merge sort took: " + (endTime - startTime) / 1000000 + "ms");
    }

    
}
