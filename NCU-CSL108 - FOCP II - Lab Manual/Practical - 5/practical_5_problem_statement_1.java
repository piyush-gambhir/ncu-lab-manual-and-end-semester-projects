/*
Create a class named 'Shape' with a method to print "This is This is shape". Then create two other classes named 'Rectangle', 'Circle' inheriting the Shape class, both 
having a method to print "This is rectangular shape" and "This is circular shape" 
respectively. Create a subclass 'Square' of 'Rectangle' having a method to print 
"Square is a rectangle". Now call the method of 'Shape' and 'Rectangle' class by the 
object of 'Square' class.
*/

/**
 * practical_5_problem_statement_1
 */

class Shape {

    void PrintMessage_Shape() {
        System.out.println("This is Shape");
    }
}

class Rectangle extends Shape {
    void PrintMessage_Rectangle() {
        System.out.println("This is Rectangular Shape");
    }
}

class Circle extends Shape {
    void PrintMessage_Circle() {
        System.out.println("This is a Circle");
    }
}

class Square extends Rectangle {
    void PrintMessage_Square() {
        System.out.println("Square is a Rectangle");
    }
}

public class practical_5_problem_statement_1 {

    public static void main(String[] args) {
        Square s = new Square();

        s.PrintMessage_Shape();
        s.PrintMessage_Rectangle();

    }
}