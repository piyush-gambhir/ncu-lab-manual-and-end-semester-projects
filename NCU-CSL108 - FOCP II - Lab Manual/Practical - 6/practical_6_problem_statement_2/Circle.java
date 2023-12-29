interface GeometricalObject {

    double getPerimeter();

    double getArea();
}

class Circle implements GeometricalObject {
    double radius = 1.0;

    public Circle() {

    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}
