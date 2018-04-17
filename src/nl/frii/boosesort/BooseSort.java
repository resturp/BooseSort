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

package nl.frii.boosesort;

import java.util.Random;

/**
 *
 * @author thomas
 */
public class BooseSort {

    /**
     * Sort an array, comparing pairwise. Assuming each iteration a longer
     * sorted sublist until the complete list is sorted. Without recursion...
     *
     * x  x x  x x  x x
     * |__| |__| |__| | 
     *  |_____|   |___| 
     *   |__________|
     *
     * @param toSort array to sort
     * @return sorted array
     */
    public static Comparable[] sort(Comparable[] toSort) {

        //calc the longest sublist;
        int longestSublist = 1;
        while (longestSublist * 2 < toSort.length) {
            longestSublist *= 2;
        }

        //Do we need 1 extra clone step to sort the input?
        boolean needToSwap = false;

        //we will use 1 extra array
        Comparable[] target = new Comparable[toSort.length];

        //double the sublistlength untill we reached the longest sublist
        int subListLength = 1;
        while (subListLength <= longestSublist) {
            int offset = 0; //start of the left_part to merge

            while (offset < toSort.length) {
                int left = 0, right = 0, partitionSize = 0;

                //the partition size to sort. prevent sorting items after
                //the end of the array
                if (2 * subListLength + offset > toSort.length) {
                    partitionSize = toSort.length - offset;
                } else {
                    partitionSize = subListLength * 2;
                }

                for (int t = 0; t < partitionSize; t++) {
                    //no more element in the left sublist?
                    if (left >= subListLength) {
                        //take element from right sublist
                        target[offset + t] = toSort[offset + subListLength + right++];
                    } else {
                        //no more element in the right sublist?
                        if (right >= partitionSize - subListLength) {
                            //take element from left sublist
                            target[offset + t] = toSort[offset + left++];
                        } else {
                            //compare element right and left
                            if (toSort[offset + left].compareTo(toSort[offset + subListLength + right]) < 0) {
                                //take element from left sublist
                                target[offset + t] = toSort[offset + left++];
                            } else {
                                //take element from right sublist
                                target[offset + t] = toSort[offset + subListLength + right++];
                            }
                        }
                    }
                }
                //look at the next sublist pair.
                offset += 2 * subListLength;
            }

            //double the size of sublists and swap array toSort, target
            subListLength = subListLength * 2;
            Comparable[] temp = toSort;
            toSort = target;
            target = temp;
            needToSwap = !needToSwap;
        }

        if (needToSwap) {
            int i =0;
            for (Comparable c : toSort) {
                target[i] = toSort[i++];
            }
        }

        return toSort;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[][] toSort = {
            {}, {0},{0,1}, {1,0},{6,3,2},{2,7,9},
            {2, 3, 1, 5, 7, 33, 5, 4, 6},
            {7, 3, 1, 5, 2, 33, 6}
        };

        for (Integer[] list : toSort) {
            Comparable[] c = BooseSort.sort(list);
            
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }

    }

}
