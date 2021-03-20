package assignment6;

import java.util.Arrays;

public class NGramStemmer {
    public String[] getNGrams(String given, int n) {
        String[] array = given.split("");
        String[] N_Grams = {};
        if (n != 0) {
            int quantityGrams = (int) Math.ceil((float) array.length / n);
            N_Grams = new String[quantityGrams];

//            N_Grams= gramHelper(array, n, N_Grams, quantityGrams, given);
            if (array.length == n) {
                N_Grams[0] = given;
            } else {
                String helper = "";
                for (int i = 0; i < quantityGrams; i++) {

                    for (int j = i * n; j < (i + 1) * n; j++) {
                        if (array.length > j && array.length>0 && array[0] !="")
                            helper += array[j];
                        else
                            helper += "*";
                    }
                    N_Grams[i] = helper;
                    helper = "";
                }
            }
            return N_Grams;
        } else {
//            if n is 0 return empty array
            return N_Grams;
        }
    }

    public int getShared(String given1, String given2, int n) {
        String[] N_Grams1 = getNGrams(given1, n);
        String[] N_Grams2 = getNGrams(given2, n);
//      printing to see how the strings are divided into ngrams
        System.out.println(Arrays.toString(N_Grams1));
        System.out.println(Arrays.toString(N_Grams2));
        int similarity = 0;
        for (int i = 0; i < N_Grams1.length; i++) {
            if (i < N_Grams2.length && N_Grams1[i].equals(N_Grams2[i])) {
                similarity++;
            }
        }
        return similarity;
    }


    public double getDistance(String given1, String given2, int n){
        String[] N_Grams1 = getNGrams(given1, n);
        String[] N_Grams2 = getNGrams(given2, n);
        int similarity = getShared(given1, given2, n);
        return (double) similarity/(N_Grams1.length+N_Grams2.length);
    }

}

class Main{
    public static void main(String[] args) {
        NGramStemmer object = new NGramStemmer();
//        in the forum it was said that i cannot make all the classes (i assume it was a mistake and they meant methods) static.
//        thats why i create an object instead, to not use static cuz from main we can call only static methods

        System.out.println(Arrays.toString(object.getNGrams("", 2)));
        System.out.println("--------------- task 1 ----------------");


        System.out.println(object.getShared("d", "caelogpigpogdigsh", 5));
        System.out.println("--------------- task 2 ----------------");

        System.out.println(object.getDistance("dadanene", "daneneda", 2));
        System.out.println("--------------- task 3 ----------------");

    }
}