#include <stdio.h>

int main()
{

    int num;
    printf("Enter Number: ");
    scanf("%d", &num);

    if (num > 0){
        int i = 1;
        int factorial = 1;
        while (i <= num){
            factorial = factorial * i;
            i += 1;
        }
        printf("Factorial of %d: %d", num, factorial);
    }
    else{
        printf("Error! Enter a Positive Number");
    }
    return 0;
}
