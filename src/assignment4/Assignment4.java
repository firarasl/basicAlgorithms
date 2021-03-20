package assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment4 {
    public static void sort(int[] numbers) {
        if (numbers.length > 1) {
            int helper;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    helper = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = helper;
                    i = 0;
                }
            }
        }
    }


    public static String decimalToBinary(int number) {
        List<Integer> answerList = new ArrayList<>();
        while (number > 0) {
            answerList.add(number % 2);
            number = number / 2;
        }
        Collections.reverse(answerList);
        return answerList.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }

    public static int find(int[] numbers, int numberToCheck) {
        boolean flag = true;
        int min = 0;
        int middleIndex = 0;
        int max = numbers.length - 1;
        //in accordance with the assignment description, theres an additional -1 in index detection
        while (flag) {
            middleIndex = (max + min) / 2;
            // if numberToCheck is not inside the array
            if (min == max) {
                if (numbers[min] < numberToCheck) {
                    middleIndex = -1 * (min + 2);
                } else if (numbers[min] > numberToCheck) {
                    middleIndex = -1 * (min + 1);
                }
                flag = false;
            }
            // if numberToCheck is inside the array
            else if (numbers[middleIndex] > numberToCheck) {
                max = middleIndex;
            } else if (numbers[middleIndex] < numberToCheck) {
                min = middleIndex + 1;
            } else if (numbers[middleIndex] == numberToCheck) {
                flag = false;
            }
        }
        return middleIndex;
    }


    public static void main(String[] args) {
        int values[] = { 9, -3, 5, 0, 1};
        System.out.println("BUBBLE SORT array before " + Arrays.toString(values));
        sort(values);
        System.out.println("BUBBLE SORT array after " +Arrays.toString(values));


        System.out.println("----------------------------------end of task 1 ---------------------------------");

        System.out.println( "17 in binary is " + decimalToBinary(17));
        System.out.println("----------------------------------end of task 2 ---------------------------------");

        int[] array = {1, 1, 2, 3, 11, 12, 13, 24, 38, 55};
        System.out.println("array is " + Arrays.toString(array));

        System.out.println("index of 3 in array " +find(array, 3));
        System.out.println("index of 0 in array should be " +find(array, 0));
        System.out.println("index of 7 in array should be "+find(array, 7));
        System.out.println("index of 55 in array " +find(array, 55));
        System.out.println("index of 1 in array " +find(array, 1));
        System.out.println("index of 11 in array " +find(array, 11));
        System.out.println("index of 22 in array should be " +find(array, 22));
        System.out.println("index of 222 in array should be " +find(array, 222));


        System.out.println("----------------------------------end of task 3 ---------------------------------");
    }

}
