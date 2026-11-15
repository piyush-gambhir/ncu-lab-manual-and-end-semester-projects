

















import java.lang.Math;

class point {
    float x;
    float y;

    point() {

    }

    point(float temp_x, float temp_y) {
        this.x = temp_x;
        this.y = temp_y;
    }

    float getx() {
        return this.x;
    }

    float gety() {
        return y;
    }

    void setx(float temp_x) {
        this.x = temp_x;
    }

    void sety(float temp_y) {
        this.y = temp_y;
    }

    double Distance(point p) {
        double distance = Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
        System.out.printf("\n\nThe Distance Between Two Points is: %2.7f", distance);
        return distance;
    }
}

public class practical_4_problem_statement_5 {

    public static void main(String[] args) {
        point p1 = new point(3, 5);
        point p2 = new point(2, 3);

        System.out.println("x1: " + p1.getx());
        System.out.print("y1: " + p1.gety());
        System.out.print("\n\n");
        System.out.println("x2: " + p2.getx());
        System.out.print("y2: " + p2.gety());

        p1.setx(2);
        p1.sety(9);

        p2.sety(4);
        p2.sety(6);

        System.out.print("\n\n");

        System.out.println("x1: " + p1.getx());
        System.out.print("y1: " + p1.gety());
        System.out.print("\n\n");
        System.out.println("x2: " + p2.getx());
        System.out.print("y2: " + p2.gety());

        p1.Distance(p2);

    }
}
