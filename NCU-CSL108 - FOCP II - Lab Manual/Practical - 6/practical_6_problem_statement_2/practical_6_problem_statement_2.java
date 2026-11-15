















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