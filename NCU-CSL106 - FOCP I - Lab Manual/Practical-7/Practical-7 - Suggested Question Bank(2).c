#include <stdio.h>
#include <math.h>

int area(float, float, float);
int perimeter(float, float, float);

int main()
{
    float a, b, c;

    printf("\nEnter 3 Sides of the Triangle: ");
    scanf("%f %f %f", &a, &b, &c);

    printf("\nEnter 1 For Calculating Area of Triangle");
    printf("\nEnter 2 For Calculating Perimeter of Triangle");

    int user_choice;
    printf("\nEnter Your Choice: ");
    scanf("%d", &user_choice);

    printf("\n");

    switch (user_choice)
    {
    case 1:
        area(a, b, c);
        break;
    case 2:
        perimeter(a, b, c);
        break;
    default:
        printf("\nInvalid User Input");
    }
    return 0;
}

int area(float a, float b, float c)
{
    float semi_perimeter = (a + b + c) / 2;
    float area = pow((semi_perimeter * (semi_perimeter - a) * 
    (semi_perimeter - b) * (semi_perimeter - c)), 0.5);
    printf("The Area of Triangle = %.2f", area);
    return 0;
}

int perimeter(float a, float b, float c)
{
    float perimeter = a + b + c;
    printf("The Perimeter of Triangle = %.2f", perimeter);
    return 0;
}




