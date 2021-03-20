package assignment10;

public class Main {
    public static void main(String[] args) {
//        checking student class

        Student maria = new Student();
        maria.addCourseGrade("APAS", 100);
        maria.addCourseGrade("SEPB", 99);
        maria.addCourseGrade("DAF", 98);
        maria.printGrades();
        System.out.println(maria.getAverageGrade());
        System.out.println(maria);


//        checking wizard class

        Wizard harryPotter = new Wizard(10,12,50,50);
        System.out.println(harryPotter.craft());
        System.out.println(harryPotter.doSell(60));
        System.out.println(harryPotter.displayInventory());
    }
}
