package assignment5;

import java.util.Arrays;

public class Assignment5 {
    public static int[][] multiplyMatrix(int row1, int col1, int A[][], int row2, int col2, int B[][]) {
        int[][] answer = null;
        int value;
        if (col1 == row2) {
            answer = new int[row1][col1];
            for (int i = 0; i < row1; i++) {
                for (int u = 0; u < col1; u++) {
                    value = 0;
                    for (int j = 0; j < col1; j++) {
                        value += A[i][j] * B[j][u];
                    }
                    answer[i][u] = value;
                }
            }
        } else {
            answer = new int[1][2];
            answer[0][0] = 0;
            answer[0][1] = 0;
        }
        return answer;
    }


    public static int productDiagonals(int arr[][], int n) {
        int leftDiagonal = 1;
        int rightDiagonal = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    leftDiagonal *= arr[i][j];
                }
            }

            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i + j == arr[0].length - 1) {
                    rightDiagonal *= arr[i][j];
                }
            }
        }
        return leftDiagonal * rightDiagonal;
    }


    public static int[][] spiralFill(int m, int n) {
        int incrementedValue = 1;
        int[][] resultArray = new int[m][n];

        int helper = 0;

        for (int i = 0; i < m && helper < n; i++) {
            int j = helper;
            // WORKFLOW: fill the first row; fill the rightest column; fill the lowest row; fill first column
            while (j < n) {
                resultArray[i][j] = incrementedValue;
                incrementedValue++;
                j++;
            }
//            increasing i to get to the next row
            i++;
            int r = i;
            while (r < m) {
                resultArray[r][n - 1] = incrementedValue;
                incrementedValue++;
                r++;
            }
//            decreasing n to shift the column filling to the left
            n--;

            if (i < m) {
                int p = n - 1;
                while (p >= helper) {
                    resultArray[m - 1][p] = incrementedValue;
                    incrementedValue++;
                    p--;
                }
                m--;
            }

            if (helper < n) {
                int e = m - 1;
                while (e >= i) {
                    resultArray[e][helper] = incrementedValue;
                    incrementedValue++;
                    e--;
                }
                helper++;

            }
            i--;
        }

        return resultArray;
    }


    public static void main(String[] args) {
        int A[][] = {
                {1, 2},
                {3, 4}
        };
        int B[][] = {
                {1, 1},
                {1, 1}
        };
        System.out.println(Arrays.deepToString(multiplyMatrix(A.length, A[0].length, A, B.length, B[0].length, B)));

        System.out.println("------------------------~ end of task 1 ~-----------------------------------");


        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 7, 4, 2},
                {2, 2, 2, 1}};
        System.out.println(productDiagonals(arr, 4));
        System.out.println("------------------------~ end of task 2 ~-----------------------------------");


        int m = 4;
        int n = 4;
        int[][] resultArray = spiralFill(m, n);
//iteration through array to print it;  Arrays.deepToString would print it in line
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                \t to make space to beautify
                System.out.print(resultArray[i][j] + "\t");
            }
//            new line after each row
            System.out.println();
        }
        System.out.println("------------------------~ end of task 3 ~-----------------------------------");

    }


}
