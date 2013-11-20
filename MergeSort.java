package javaapplication15;

public class MergeSort {

    public static int[] temp;

    public static void mergeSort(int[] n, int low, int high) {


        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(n, low, mid);
        mergeSort(n, mid + 1, high);
        doMerge(n, low, mid, high);
    }

    public static void doMerge(int[] n, int low, int mid, int high) {

        int i = 0;
        int j = mid + 1;
        for (int id = low; id <= high; id++) {
            temp[id] = n[id];
        }
        for (int id = low; id <= high; id++) {
            if (i > mid) {
                n[id] = temp[j++];
            } else if (j > high) {
                n[id] = temp[i++];
            } else if (temp[i] < temp[j]) {
                n[id] = temp[i++];
            } else {
                n[id] = temp[j++];

            }

        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{5, 4, 3, 2, 1};
        temp = new int[n.length];
        MergeSort.mergeSort(n, 0, n.length - 1);

    }
}
