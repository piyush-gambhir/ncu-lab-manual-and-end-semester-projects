#include <stdio.h>

int add(int, int);
int sub(int, int);
int mul(int, int);
int div(int, int);

int main()
{
    int num_1, num_2, user_choice;

    printf("Enter Number 1: ");
    scanf("%d", &num_1);
    printf("Enter Number 2: ");
    scanf("%d", &num_2);

    printf("\nEnter 1 For Addition.\n");
    printf("Enter 2 For Subtraction.\n");
    printf("Enter 3 For Multiplication.\n");
    printf("Enter 4 For Division.\n");

    printf("\nEnter Your Choice: ");
    scanf("%d", &user_choice);

    printf("\n");

    switch (user_choice)
    {
    case 1: add(num_1, num_2);
        break;
    case 2: sub(num_1, num_2);
        break;
    case 3: mul(num_1, num_2);
        break;
    case 4: div(num_1, num_2);
        break;
    default: printf("Invalid User Choice!");
    }
}

int add(int a, int b)
{
    int add = a + b;
    printf("Addition of %d and %d = %d", a, b, add);
    return 0;
}
int sub(int a, int b)
{
    int sub = a - b;
    printf("Subtraction of %d and %d = %d", a, b, sub);
    return 0;
}

int mul(int a, int b)
{
    int mul = a * b;
    printf("Multiplication of %d and %d = %d", a, b, mul);
    return 0;
}

int div(int a, int b)
{
    int div = a / b;
    printf("Division of %d and %d = %d", a, b, div);
    return 0;
}



