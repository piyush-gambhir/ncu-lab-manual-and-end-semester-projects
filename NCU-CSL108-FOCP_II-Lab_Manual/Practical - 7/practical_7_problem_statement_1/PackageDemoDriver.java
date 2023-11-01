/*

Create a Java package called exercises. Inside the exercises package, create another package (subpackage) called java. Create a Java class called PackageDemo inside the java package. Insert a display() method inside the PackageDemo class. 
Inside the method, insert this statement:System.out.println("PackageDemo executed");Write a PackageDemoDriver class within the same package to run the display () method of PackageDemo class.

*/

/**
 * practical_7_problem_statement_2
 */

package exercise.java;

import exercise.java.PackageDemo;

public class PackageDemoDriver {
    public static void main(String[] args) {
        PackageDemo PDD = new PackageDemo();
        PDD.display();
    }
}