package com.github.ascis055.LCupcakes.sort;

public class BubbleSort {

  public static int count = 0;

  // bubble sort array, O(n^2), unoptimized brute force solution
  public static void SortStrings(String[] arr) {

    count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (j + 1 < arr.length) {
          if (arr[j].compareTo(arr[j + 1]) > 0) {
            swap(arr, j, j + 1);
          }
        }
        // increase count
        count++;
      }
    }
  }

  // swap
  public static void swap(String[] arr, int a, int b) {
    String temp;

    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

}
