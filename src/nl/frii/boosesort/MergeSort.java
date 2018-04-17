/* source from Stack Overflow dot com */

package nl.frii.boosesort;

/**
 *
 * @author thomas
 */
public class MergeSort {

    static void mergesort(Comparable[] ao) {
        if (ao.length <= 1) {
            return; // klaar
        }
        /* splitsen */
        int i1 = ao.length / 2;
        Comparable[] aoL = new Comparable[i1];
        for (int i = 0; i < i1; i++) {
            aoL[i] = ao[i];
        }
        Comparable[] aoR = new Comparable[ao.length - i1];
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
            } else if (aoL[iL].compareTo(aoR[iR]) < 0) {
                ao[i] = aoL[iL++];
            } else {
                ao[i] = aoR[iR++];
            }
        }
    }


    public static Comparable[] sort(Comparable[] toSort) {
        mergesort (toSort);
        return toSort;
    }


}
