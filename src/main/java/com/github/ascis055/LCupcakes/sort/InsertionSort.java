package com.github.ascis055.LCupcakes.sort;

public class InsertionSort {

  public static int count = 0;

  /* Function to sort array using insertion sort */
  public static void SortStrings(String[] arr) {
    count = 0;
    for (int i = 1; i < arr.length; ++i) {
      String key = arr[i];
      int j = i - 1;

      /* Move elements of arr[0..i-1], that are
         greater than key, to one position ahead
         of their current position */
      while (j >= 0 && arr[j].compareTo(key) > 0) {
        arr[j + 1] = arr[j];
        j = j - 1;
        // increment count
        count++;
      }
      arr[j + 1] = key;
    }
  }

}
