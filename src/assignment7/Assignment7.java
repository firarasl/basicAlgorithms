package assignment7;

import java.util.Collections;
import java.util.LinkedList;

public class Assignment7 {

    static boolean checkHankelMatrix(int n, int[][] array){
        int j =0;
        int iCopy = 0;
        int constant=0;
        for (int i = 0; i < n; i++) {
            j=0;
            constant= array[i][j];
//            using icopy instead of i to omit infinit loop
            iCopy = i;
            while(iCopy>0 && j<n){
                    iCopy-=1;
                    j+=1;
                    if (array[iCopy][j] !=constant){
                        return false;
                    }
                }

//            if its the last row then i should iterate all the elements in the row
            if (i==n-1){
                for (int k = 1; k < n; k++) {
                    constant= array[i][k];
                    iCopy = i;
                    j=k;
                    while(iCopy>0 && j<n-1){
                        iCopy-=1;
                        j+=1;
                        if (array[iCopy][j] !=constant){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

//    java's linked list approach
//    static LinkedList<Integer> hankelList(int[][] m){
//        if (checkHankelMatrix(m[0].length, m)){
//            LinkedList<Integer> linkedList=new LinkedList<>();
//            for (int i = 0; i < m[0].length; i++) {
//                for (int j = 0; j < m[0].length; j++) {
//                    linkedList.add(m[i][j]);
//                }
//            }
//            Collections.sort(linkedList);
//            return linkedList;
//        }
//        else{
//            return null;
//        }
//    }



//custom linked list approach
    static LinkedListCustom hankelList(int[][] m){
        if (checkHankelMatrix(m[0].length, m)){
            LinkedListCustom linkedList=new LinkedListCustom();
            linkedList.sort(m);

            return linkedList;
        }
        else{
            return null;
        }
    }

    public static void main(String[] args) {
        int m[][] = {{1, 2, 3, 5},
                {2, 3, 5, 8},
                {3, 5, 8, 0},
                {5, 8, 0, 9} };
//using m[0].length instead of n for flexibility
        System.out.println(checkHankelMatrix(m[0].length, m));
        System.out.println(hankelList(m));
    }
}
