package assignment10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private int age;
    private String address;
    private int numCourses;
    private String[] courses;
    private int[] grades;

    Scanner scanner = new Scanner(System.in);

    Pattern regex = Pattern.compile("^[0-9<>.*;\",#%&()=+!\\s-]+$");

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Student() {
        System.out.println("give me student name");
        this.name = scanner.next();
        System.out.println("give me student age");
        this.age = scanner.nextInt();
        if (this.age >21 || this.age<15){
            throw new AgeNotWithinRangeException();
        }
         if(regex.matcher(this.name).find()){
            throw new NameNotValidException();
        }
        System.out.println("give me student address");
        this.address = scanner.next();
            this.grades=new int[30];
            this.courses=new String[30];
            this.numCourses=0;

    }


    public void addCourseGrade(String course, int grade){
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    public void printGrades(){
        for (int i = 0; i < numCourses; i++) {
//            "name course1:grade1, course2:grade2,...".
            System.out.print(courses[i]+":"+grades[i]);
            if (i != numCourses-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public int getAverageGrade(){
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum+=grades[i];
        }
        return sum/numCourses;
    }

    @Override
    public String toString() {
//        name(age,address)
        return this.name+"("+this.age+","+this.address+")";
    }
}
