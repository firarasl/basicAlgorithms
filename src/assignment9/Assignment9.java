package assignment9;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment9 {
    public static void main(String[] args) {
        Person A = new Person("DE", 15011998);
        DocumentOffice berlin = new DocumentOffice("DE", 15012010);
        System.out.println(berlin.requestDocuments(A, 1));
        System.out.println(berlin.requestDocuments(A, 2));
        System.out.println(berlin.returnDatabase());
        System.out.println(Arrays.toString(berlin.find(A)));
        System.out.println(berlin.addPenalty(A,20));
        System.out.println(berlin.updateDate(19012010));
    }
}
