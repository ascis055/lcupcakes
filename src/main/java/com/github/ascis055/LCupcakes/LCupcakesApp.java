package com.github.ascis055.LCupcakes;

import java.util.*;
import org.json.simple.*;
import com.github.ascis055.LCupcakes.sort.*;

/*
 * lcupcakes
 */
public class LCupcakesApp {
  public static void main(String[] args) {
    String fileName =
      "/home/sasha/cis055/lcupcakes/lcupcakesapp/cupcake_3906.json";


    // read cupcake names
    JSONArray cupcakeArray = JSONFile.readArray(fileName);
    String[] cupcakeNameArray = nameArray(cupcakeArray);

    // print unsorted list
    System.out.println("----- Unsorted array -----");
    print(cupcakeNameArray);

    // sort
    MergeSort.SortStrings(cupcakeNameArray);

    // print sorted list
    System.out.println("----- Sorted array -----");
    print(cupcakeNameArray);

    System.out.println("----- Statistics -----");
    System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
    System.out.printf("Count = %d\n", MergeSort.count);
  }

  // print array
  public static void print(String[] arr) {
    System.out.printf("Number\tName\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%04d\t%s\n", i, arr[i]);
    }
  }

  // get array of cupcake names
  public static String[] nameArray(JSONArray cupcakeArray) {
    String[] arr = new String[cupcakeArray.size()];

    // get names from json object
    for (int i = 0; i < cupcakeArray.size(); i++) {
      JSONObject o = (JSONObject) cupcakeArray.get(i);
      String name = (String) o.get("name");
      arr[i] = name;
    }
    return arr;
  }

}
