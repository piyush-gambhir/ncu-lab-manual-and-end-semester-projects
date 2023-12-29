#include <stdio.h>

int sum_of_two_primes(int);

int main()
{
    int num;
    printf("Enter the Number: ");
    scanf("%d", &num);

    int flag = 0;

    for (int i = 2; i <= num; ++i)
    {
        if (sum_of_two_primes(i) == 1)
        {
            if (sum_of_two_primes(num - i) == 1)
            {
                printf("%d can be expressed as the sum of %d and %d", num, i, num - i);
                flag = 1;
            }
        }
    }
    printf("\n");
    return 0;
}

int sum_of_two_primes(int n)
{
    int i, is_Prime = 1;
    for (i = 2; i <= n / 2; ++i)
    {
        if (n % i == 0)
        {
            is_Prime = 0;
            break;
        }
    }
    return is_Prime;
}






