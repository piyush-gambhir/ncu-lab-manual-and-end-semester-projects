#include <stdio.h>
#include <math.h>

int Binary_To_Decimal(long long int);
int Decimal_To_Binary(int);

int main()
{
    printf("Enter 1 to Convert Binary to Decimal");
    printf("\nEnter 2 to Convert Decimal to Binary");

    int user_choice;
    printf("\nEnter Your Choice: ");
    scanf("%d", &user_choice);

    if (user_choice = 1)
    {
        long long int binary_num;
        printf("\nEnter the Binary Number: ");
        scanf("%lld", &binary_num);

        int decimal = Binary_To_Decimal(binary_num);
        printf("%lld Binary Number = %d in Decimal Number", binary_num, decimal);
    }

    else if (user_choice = 2)
    {
        int decimal_num;
        printf("\nEnter the Decimal Number: ");
        scanf("%d", &decimal_num);

        long long int binary = Decimal_To_Binary(decimal_num);
        printf("%d Decimal Number = %lld in  Number", decimal_num, binary);
    }

    else
    {
    }
    return 0;
}

int Binary_To_Decimal(long long int n)
{
    int decimal = 0, rem;
    int i = 0;
    while (n != 0)
    {
        rem = n % 10;
        n /= 10;
        decimal += rem * pow(2, i);
        ++i;
    }
    return decimal;
}

int Decimal_To_Binary(int n)
{
    long binary = 0;
    int rem, temp = 1;

    while (n != 0)
    {
        rem = n % 2;
        n = n / 2;
        binary = binary + rem * temp;
        temp = temp * 10;
    }
    return binary;
}





