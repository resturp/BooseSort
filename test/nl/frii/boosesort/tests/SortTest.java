/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.frii.boosesort.tests;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        int[] leeg = new int[0];
        Assert.assertArrayEquals("Empty in should return empty out.", BooseSort.sort(leeg), leeg);
        Assert.assertArrayEquals("Merge: Empty in should return empty out.", MergeSort.sort(leeg), leeg);
    }

    @Test
    public void TestSingleItemArray() {
        int[] single = {0};
        Assert.assertArrayEquals("Single in should return same single out.", BooseSort.sort(single), single);
        Assert.assertArrayEquals("Merge: Single in should return same single out.", MergeSort.sort(single), single);
    }

    @Test
    public void TestTwoItemsSortedArray() {
        int[] twoInts = {0, 2};
        Assert.assertArrayEquals("These two items were sorted going in.", BooseSort.sort(twoInts), twoInts);
        Assert.assertArrayEquals("Merge: These two items were sorted going in.", MergeSort.sort(twoInts), twoInts);
    }

    @Test
    public void TestTwoItemsNotSortedArray() {
        int[] twoInts = {6, 0};
        int[] twoIntsOut = {0, 6};

        Assert.assertArrayEquals("These two items should have switched.", BooseSort.sort(twoInts), twoIntsOut);
        Assert.assertArrayEquals("Merge: These two items should have switched.", MergeSort.sort(twoInts), twoIntsOut);
    }

    @Test
    public void TestEightItemsNotSortedArray() {
        int[] eightInts = {0, 6, 3, 5, 9, 1, 1, 5};
        int[] eightIntsOut = {0, 1, 1, 3, 5, 5, 6, 9};

        Assert.assertArrayEquals("Single in should return same single out.", BooseSort.sort(eightInts), eightIntsOut);
        Assert.assertArrayEquals("Merge: Single in should return same single out.", MergeSort.sort(eightInts), eightIntsOut);
    }

    @Test
    public void TestSevenItemsNotSortedArray() {
        int[] sevenInts = {0, 6, 3, 9, 1, 1, 5};
        int[] sevenIntsOut = {0, 1, 1, 3, 5, 6, 9};

        Assert.assertArrayEquals("Single in should return same single out.", BooseSort.sort(sevenInts), sevenIntsOut);
        Assert.assertArrayEquals("Merge: Single in should return same single out.", MergeSort.sort(sevenInts), sevenIntsOut);
    }

    @Test
    public void TestFiveItemsNotSortedArray() {
        int[] fiveInts = {0, 6, 3, 9, 1};
        int[] fiveIntsOut = {0, 1, 3, 6, 9};

        Assert.assertArrayEquals("These five should return sorted array.", BooseSort.sort(fiveInts), fiveIntsOut);
        Assert.assertArrayEquals("Merge: These five should return sorted array.", MergeSort.sort(fiveInts), fiveIntsOut);
    }

    @Test
    public void TestFiveItemsNotSortedArrayLastGoesFirst() {
        int[] fiveInts = {9, 6, 3, 1, 0};
        int[] fiveIntsOut = {0, 1, 3, 6, 9};

        Assert.assertArrayEquals("These five should return sorted array.", BooseSort.sort(fiveInts), fiveIntsOut);
        Assert.assertArrayEquals("Merge: These five should return sorted array.", MergeSort.sort(fiveInts), fiveIntsOut);
    }

    @Test
    public void TestFiveItemsNotSortedArrayLastGoesLast() {
        int[] fiveInts = {3, 6, 0, 1, 9};
        int[] fiveIntsOut = {0, 1, 3, 6, 9};

        Assert.assertArrayEquals("These five should return sorted array.", BooseSort.sort(fiveInts), fiveIntsOut);
        Assert.assertArrayEquals("Merge: These five should return sorted array.", MergeSort.sort(fiveInts), fiveIntsOut);
    }

        @Test
    public void TestFiftyThousandItemsNotSortedArrayLastGoesLast() {
        Random rand = new Random();

        int[] fiftyThousandInts = new int[50000];
        int[] fiftyThousandIntsOut = new int[50000];

        for (int i = 0; i < 50000; i++) {
            fiftyThousandInts[i] += rand.nextInt();
        }
        
        fiftyThousandIntsOut = BooseSort.sort(fiftyThousandInts);

        long startTime = System.nanoTime();
        Assert.assertArrayEquals("These five milion should return sorted array.", BooseSort.sort(fiftyThousandInts), fiftyThousandIntsOut);
        long endTime = System.nanoTime();
        System.out.println("Boose sort took: " + (endTime - startTime) / 1000000 + "ms");
        startTime = System.nanoTime();
        Assert.assertArrayEquals("Merge: These five milion should return sorted array.", MergeSort.sort(fiftyThousandInts), fiftyThousandIntsOut);
        endTime = System.nanoTime();
        System.out.println("Merge sort took: " + (endTime - startTime) / 1000000 + "ms");
    }

    
    @Test
    public void TestFiveMilionItemsNotSortedArrayLastGoesLast() {
        Random rand = new Random();

        int[] fiveMilionInts = new int[5000000];
        int[] fiveMilionIntsOut = new int[5000000];

        for (int i = 0; i < 5000000; i++) {
            fiveMilionInts[i] += rand.nextInt();
        }
        
        fiveMilionIntsOut = BooseSort.sort(fiveMilionInts);

        long startTime = System.nanoTime();
        Assert.assertArrayEquals("These five milion should return sorted array.", BooseSort.sort(fiveMilionInts), fiveMilionIntsOut);
        long endTime = System.nanoTime();
        System.out.println("Boose sort took: " + (endTime - startTime) / 1000000 + "ms");
        startTime = System.nanoTime();
        Assert.assertArrayEquals("Merge: These five milion should return sorted array.", MergeSort.sort(fiveMilionInts), fiveMilionIntsOut);
        endTime = System.nanoTime();
        System.out.println("Merge sort took: " + (endTime - startTime) / 1000000 + "ms");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
