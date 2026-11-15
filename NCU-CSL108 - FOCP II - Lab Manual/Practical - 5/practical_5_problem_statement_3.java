import Box.BoxWeight;
















class Box {
    float length;
    float width;
    float depth;

    public Box() {

    }

    public Box(float l, float w, float d) {
        this.length = l;
        this.width = w;
        this.depth = d;
    }

    void setlength(float len) {
        this.length = len;
    }

    void setwidth(float wid) {
        this.length = wid;
    }

    void setdep(float dep) {
        this.depth = dep;
    }

    float getlength() {
        return this.length;
    }

    float getwodth() {
        return this.width;
    }

    float getdepth() {
        return this.depth;
    }

    float volume() {
        float volume = this.length * this.width * this.depth;
        return volume;
    }

    class BoxWeight extends Box {
        float weight;

        void setweight(float weight) {
            this.weight = weight;
        }

        float getlength() {
            return this.weight;
        }

        float weight() {

            return weight;
        }
    }

}

public class practical_5_problem_statement_3 {

    public static void main(String[] args) {

        Box box = new Box(12, 12, 12);
        BoxWeight boxweigth = new BoxWeight();

        System.out.println("Volume: " + box.volume());

        boxweight.setweight(10);

        System.out.println();
    }
}
