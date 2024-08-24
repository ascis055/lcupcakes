package com.github.ascis055.LCupcakes.sort;

public class MergeSort {

  public static int count = 0;

  // merge sort array, O(n logBase2 n)
  public static void SortStrings(String[] arr) {
    // call recurisve merge method with the array
    int left = 0;
    int right = arr.length - 1;
    count = 0;
    sort(arr, left, right);
  }

  // merge sort
  public static void sort(String[] arr, int left, int right) {
    // if left >= right, we are done
    if (left >= right) {
      return;
    }
    // split the array in half, sort each half recursively, then merge
    int middle = left + ((right - left) / 2);

    int leftStart = left;
    int leftEnd = middle;
    int rightStart = middle + 1;
    int rightEnd = right;

    // System.out.println("merge sort left");
    // print(arr, leftStart, leftEnd);
    sort(arr, leftStart, leftEnd);

    // System.out.println("merge sort right");
    // print(arr, rightStart, rightEnd);
    sort(arr, rightStart, rightEnd);

    // merge the two sorted arrays
    merge(arr, left, middle, right);
    // System.out.println("after merge");
    // print(arr, left, right);
  }

  // merge two arrays indicated by [left to middle] and [middle+1 to right]
  public static void merge(String[] arr, int left, int middle, int right) {
    // compare all the values adding them in to temp
    String[] temp = new String[right - left + 1];

    // indices for left and right
    int l = left;
    int r = middle + 1;

    // merge the elements such that lower elements go into temp first
    int t = 0;
    while ((l <= middle) && (r <= right)) {
      if ((arr[l].compareTo(arr[r])) < 0) {
        // add left element to temp
        temp[t] = arr[l];
        t++;
        l++;
      } else {
        // add right element to temp
        temp[t] = arr[r];
        t++;
        r++;
      }
    }

    // add the rest of the remaining elements (empty out the left and right arrays)

    // add any remaining left elements in to temp
    while (l <= middle) {
      // add left element to temp
      temp[t] = arr[l];
      t++;
      l++;
    }

    // add any remaining right elements in to temp
    while (r <= right) {
      // add right element to temp
      temp[t] = arr[r];
      t++;
      r++;
    }

    // copy the temp elements in to arr starting at left, element by element
    for (int i = 0; i < temp.length; i++) {
      arr[i + left] = temp[i];
    }

    // merge is a O(n) operation so we add n to the count
    count += right - left + 1;
  }

}
