











interface interface1 {
    void display1();
}

interface interface2 extends interface1 {
    void display2();
}

interface interface3 extends interface1, interface2 {
    void display3();
}

class class1 {
    void display() {
        System.out.println("This is class1.");
    }
}

class class2 extends class1 implements interface1, interface2 {
    @Override
    public void display() {
        System.out.println("This is class2.");
    }

    public void display1() {
        System.out.println("This is interface1 display function.");
    }

    public void display2() {
        System.out.println("This is interface2 display function.");
    }
}

public class practical_6_problem_statement_1 {
    public static void main(String[] args) {

        class2 c = new class2();

        c.display();
        c.display1();
        c.display1();
    }
}