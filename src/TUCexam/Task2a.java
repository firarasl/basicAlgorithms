package TUCexam;

public class Task2a {
    public static int productDiagonals(int[][] array, int size){
        int leftDiagonal = 1;
        int rightDiagonal = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j) {
                    leftDiagonal *= array[i][j];
                }
            }

            for (int j = array[0].length - 1; j >= 0; j--) {
                if (i + j == array[0].length - 1) {
                    rightDiagonal *= array[i][j];
                }
            }
        }


        if(array.length % 2 ==0){
            return leftDiagonal * rightDiagonal;
        }
        else{
            int row = (int)Math.ceil(array.length/2);

            return leftDiagonal * rightDiagonal / array[row][row];
        }


    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3},
                {5,4, 7},
                {3, 7,  2}};

        int arr2[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 7, 4, 2},
                {2, 2, 2, 1}};


        int arr3[][] = {{1, 2, 3, 4,5},
                {5, 6, 7, 8,6},
                {9, 7, 4, 2,7},
                {2, 2, 2, 1,8},
                {2, 4,2,1,1}
        };
        System.out.println(productDiagonals(arr, 3));
        System.out.println(productDiagonals(arr2, 4));
        System.out.println(productDiagonals(arr3, 5));

    }

}
