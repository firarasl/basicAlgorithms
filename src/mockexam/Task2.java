package mockexam;

class Task2 {
    public static boolean lowerTriangular(int arr[][]) {
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j >i && arr[i][j] !=0) {
                    return false;
                }
            }
        }
        return result;
    }
    public static boolean checkDiagonal(int arr[][]) {
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j !=i && arr[i][j] !=0) {
                    return false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,0,0,0},
                {6,2,0,0,0},
                {7,3,3,0,0},
                {9,2,8,2,0},
                {4,5,6,1,4}
        };
        int[][] arr2 = {{1,0,0,1},
                {6,2,0,0},
                {7,3,3,0},
                {9,2,8,2},
        };
        int[][] arr3 = {{1,0,0},
                {6,2,0},
                {7,3,3},
        };
        System.out.println(lowerTriangular(arr));
        System.out.println(lowerTriangular(arr2));
        System.out.println(lowerTriangular(arr3));

        System.out.println("---------------- end of task 1 -----------------");


        int[][] arr4 = {{1,0,0},
                {6,2,0},
                {7,3,3}
        };
        int[][] arr5= {{1,0,0,0,0},
                {0,2,0,0,0},
                {0,0,3,0,0},
                {0,0,0,2,0},
                {0,0,0,0,4}
        };
        int[][] arr6 = {{1,0,0,1},
                {0,2,0,0},
                {0,3,3,0},
                {0,0,8,2},
        };

        System.out.println(checkDiagonal(arr4));
        System.out.println(checkDiagonal(arr5));
        System.out.println(checkDiagonal(arr6));

        System.out.println("---------------- end of task 2 -----------------");

    }
}