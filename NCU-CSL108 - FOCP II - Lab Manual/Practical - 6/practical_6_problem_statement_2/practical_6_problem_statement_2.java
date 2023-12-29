/*

Define the interface / class hierarchy as detailed in the following class diagram 

Definition of Done:
DOD 1: The class definitions are defined as per the class diagram.
DOD 2: Each class definition is stored in its own .java file.
DOD 3: Base class constructors are invoked using super keyword 
DOD 4: Function overriding is applied wherever applicable.
 
*/

/**
 * practical_6_problem_statement_2
 */

public class practical_6_problem_statement_2 {

    public static void main(String[] args) {

        ResizableCircle rc = new ResizableCircle();
        rc.radius = 5;

        System.out.print("\nArea: " + rc.getArea());
        System.out.print("\nPerimeter: " + rc.getPerimeter());

        System.out.print("\n\nAfter Resizing Circle");
        rc.resize(5);
        System.out.println();

        System.out.print("\nArea: " + rc.getArea());
        System.out.print("\nPerimeter: " + rc.getPerimeter());

    }
}