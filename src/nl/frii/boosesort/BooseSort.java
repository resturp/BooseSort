/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.frii.boosesort;

/**
 *
 * @author thomas
 */
public class BooseSort {

    /**
     * Sort an array, comparing pairwise.
     * Assuming each itteration a longer sorted 
     * sublist until the complete list is sorted.
     * Without recursion...
     * 
     *   x  x  x  x  x  x  x
     *   |__|  |__|  |__|  |
     *     |_____|     |___|
     *        |__________|
     * 
     * @param toSort array to sort
     * @return sorted array
     */
    
    public static int[] sort(int[] toSort) {
        
        //calc the longest sublist;
        int longestSublist = 1;        
        while (longestSublist*2 < toSort.length) {
            longestSublist *=2;
        }
        
        //we will use 1 extra array
        int[] target = new int[toSort.length];
        
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
                
                for (int t = 0; t < partitionSize ; t++) {
                    //no more element in the left sublist?
                    if (left >= subListLength) {
                        //take element from right sublist
                        target[offset + t] = toSort[offset + subListLength + right];
                        right++;
                    } else {
                        //no more element in the right sublist?
                        if (right >= partitionSize - subListLength) {
                            //take element from left sublist
                            target[offset + t] = toSort[offset + left];
                            left++;
                        } else {
                            //compare element right and left
                            if (toSort[offset + left] < toSort[offset + subListLength + right]) {
                                //take element from left sublist
                                target[offset + t] = toSort[offset + left];
                                left++;
                            } else {
                                //take element from right sublist
                                target[offset + t] = toSort[offset + subListLength + right];
                                right++;
                            }
                        }
                    }
                }
                //look at the next sublist pair.
                offset += 2 * subListLength;
            }

            //double the size of sublists and swap array toSort, target
            subListLength = subListLength * 2;
            int[] temp = toSort;
            toSort = target;
            target = temp;
        }
        return toSort;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }

}
