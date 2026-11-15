











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