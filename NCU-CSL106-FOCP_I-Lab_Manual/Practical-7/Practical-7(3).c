#include <stdio.h>

int Sum_of_NaturalNumbers(int);

int main()
{
    int n;
    printf("Enter the Value of n: ");
    scanf("%d", &n);

    printf("The Sum of '%d' Natural Numbers is: %d", n, Sum_of_NaturalNumbers(n));
    return 0;
}

int Sum_of_NaturalNumbers(int n)
{
    int sum;
    if (n != 0)
    {
        sum = n + Sum_of_NaturalNumbers(n - 1);
        return sum;
    }
    else
    {
        return n;
    }
}


