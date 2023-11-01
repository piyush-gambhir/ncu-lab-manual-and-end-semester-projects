import Box.BoxWeight;

/*
Define a class Box with the following instance variables: width height and depth, all of type float. Create a new class BoxWeigth that extends Box to include weight as an instance variable. Write an application that tests the functionalities of both these classes.

Definition of Done:
DoD 1: Three java files to be defined. One for each class definition: Box, BoxWeight and BoxWeightDemo.
DoD 2: Box and BoxWeight should have three types of constructors defined: clone of an object, all dimensions specified as arguments, no argument.
DoD 3: Super is used to call base class constructors in derived class
DoD 4: Get and set functions defined as applicable in Box and BoxWeight classes. 
DoD 5: Function to display volume in Box class and weight in BoxWeigth class
*/

/**
 * practical_5_problem_statement_3
 */

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
