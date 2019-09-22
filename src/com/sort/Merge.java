package com.sort;

public class Merge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int k = lo; k <= hi; k++) aux[k] = a[k];

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];   //lo exhausted
            else if (j > hi) a[k] = aux[i++];    //hi exhausted
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi<=lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length -1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for (int i = lo; i < hi; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    private static boolean less(Comparable v, Comparable w){
        //v<w
        return v.compareTo(w) < 0;
    }
}
