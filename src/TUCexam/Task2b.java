package TUCexam;

public class Task2b {

    public static void search(int[][] array, int x){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == x){
                    System.out.println("Found at ("+ i + ", "+ j +")");
                    return;
                }
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        int arr[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        search(arr, 29);


        int arr2[][] = {{10, 20, 30, 40,50},
                {15, 25, 35, 45,52},
                {27, 29, 37, 48,55},
                {32, 33, 39, 50,56},
                {33, 35, 42, 54,60}
        };
        search(arr, 100);

    }
}
