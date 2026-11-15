







class Student {

    String name;
    int roll_no;

}

public class practical_4_problem_statement_1 {

    public static void main(String[] args) {

        Student john = new Student();

        john.name = "John";
        john.roll_no = 2;

        System.out.println("\n\nName of the Student: " + john.name);
        System.out.println("Roll No of the Student: " + john.roll_no);
    }
}