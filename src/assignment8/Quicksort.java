package assignment8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quicksort {

    public static void sort(int[] array){
        if (array.length >1){
            int pivotElement = array[array.length/2];
//            using arraylist because it has flexible size
            List<Integer> smallerArrayList = new ArrayList<>();
            List<Integer> biggerArrayList = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                if (array[i] < pivotElement){
                    smallerArrayList.add(array[i]);
                }else if(array[i] > pivotElement){
                    biggerArrayList.add(array[i]);
                }
            }
//            creating arrays as it was instructed in assignment
            int[] smallerArray = smallerArrayList.stream().mapToInt(i -> i).toArray();
            int[] biggerArray = biggerArrayList.stream().mapToInt(i -> i).toArray();
//            recursion
            sort(smallerArray);
            sort(biggerArray);

//            merging arrays to each other and sticking pivot in between
            System.arraycopy(smallerArray, 0, array, 0, smallerArray.length);
            array[smallerArray.length] = pivotElement;
            System.arraycopy(biggerArray, 0, array, smallerArray.length+1, biggerArray.length);
            }
    }

    public static void main(String[] args) {
        int array[] = { 3, -5,1 ,15 ,2};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
