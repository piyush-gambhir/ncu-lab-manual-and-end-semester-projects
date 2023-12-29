#include <math.h>
#include <stdio.h>

int main() {
    double a, b, c, discriminant, root_1, root_2, real_Part, imaginary_Part;
    printf("Enter coefficients a, b and c: ");
    scanf("%lf %lf %lf", &a, &b, &c);

    discriminant = b * b - 4 * a * c;

    if (discriminant > 0) {
        root_1 = (-b + sqrt(discriminant)) / (2 * a);
        root_2 = (-b - sqrt(discriminant)) / (2 * a);
        printf("root1 = %.2lf and root2 = %.2lf", root_1, root_2);
    }

    else if (discriminant == 0) {
        root_1 = root_2 = -b / (2 * a);
        printf("root1 = root2 = %.2lf;", root_1);
    }

    else {
        real_Part = -b / (2 * a);
        imaginary_Part = sqrt(-discriminant) / (2 * a);
        printf("root1 = %.2lf+%.2lfi and root2 = %.2f-%.2fi", real_Part, imaginary_Part, real_Part, imaginary_Part);
    }

    return 0;
} 

