/*
Create a class named 'Student' with String variable 'name' and integer variable 'roll_no'. Assign the value of roll_no as '2' and that of name as "John" by creating an object of the class Student.
*/

/**
 * practical_4_problem_statement_1
 */

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