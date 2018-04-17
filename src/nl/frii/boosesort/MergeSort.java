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
public class MergeSort {

    static void mergesort(int[] ao) {
        if (ao.length <= 1) {
            return; // klaar
        }
        /* splitsen */
        int i1 = ao.length / 2;
        int[] aoL = new int[i1];
        for (int i = 0; i < i1; i++) {
            aoL[i] = ao[i];
        }
        int[] aoR = new int[ao.length - i1];
        for (int i = i1; i < ao.length; i++) {
            aoR[i - i1] = ao[i];
        }
        /* subreeksen sorteren */
        mergesort(aoL);
        mergesort(aoR);
        /* subreeksen samenvoegen (ritsen) */
        /* ao kunnen we hergebruiken */
        int iL = 0;
        int iR = 0;
        for (int i = 0; i < ao.length; i++) {
            if (iL >= aoL.length) {
                ao[i] = aoR[iR++];
            } else if (iR >= aoR.length) {
                ao[i] = aoL[iL++];
            } else if (aoL[iL] < aoR[iR]) {
                ao[i] = aoL[iL++];
            } else {
                ao[i] = aoR[iR++];
            }
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void split(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            split(arr, l, m);
            split(arr, m + 1, r);

            // Merge the sorted halves
            if (l != r) {
                merge(arr, l, m, r);

            }
        }
    }

    public static int[] sort(int[] toSort) {
        mergesort (toSort);
        return toSort;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
