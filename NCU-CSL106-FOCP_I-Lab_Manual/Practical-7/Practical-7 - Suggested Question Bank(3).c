#include <stdio.h>

int Celsius_To_Fahrenheit();
int Fahrenheit_To_Celsius();

int main()
{
    printf("\nEnter 1 to Convert Degree Celsius to Degree Fahrenheit.");
    printf("\nEnter 2 to Convert Degree Fahrenheit to Degree Celsius.");

    int user_choice;
    printf("\n\nEnter Your Choice: ");
    scanf("%d", &user_choice);

    switch (user_choice)
    {
    case 1:
        Celsius_To_Fahrenheit();
        break;
    case 2:
        Fahrenheit_To_Celsius();
        break;
    default:
        printf("\nInvalid User Input!");
    }
}

int Celsius_To_Fahrenheit()
{
    float celsius;
    printf("\nEnter Temperature in Celsius: ");
    scanf("%f", &celsius);
    float fahrenheit = (celsius * 9 / 5) + 32;
    printf("%.2f Degree Celsius = %.2f Degree Fahrenheit", celsius, fahrenheit);
    return 0;
}

int Fahrenheit_To_Celsius()
{
    float fahrenheit;
    printf("\nEnter Temperature in Fahrenheit: ");
    scanf("%f", &fahrenheit);
    float celsius = (fahrenheit - 32) * 5 / 9;
    printf("%.2f Degree Fahrenheit = %.2f Degree Celsius", fahrenheit, celsius);
    return 0;
}






