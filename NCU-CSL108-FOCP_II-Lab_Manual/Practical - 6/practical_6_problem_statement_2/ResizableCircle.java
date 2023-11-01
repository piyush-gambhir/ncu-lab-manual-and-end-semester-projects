
interface Resizeable {
    void resize(int percent);
}

class ResizableCircle extends Circle implements Resizeable {

    public ResizableCircle() {
        super();
    }

    public void resize(int percent) {
        double p = percent;
        double new_radius = this.radius + this.radius * p / 100;
        this.radius = new_radius;
    }
}