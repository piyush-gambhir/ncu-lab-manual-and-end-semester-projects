#include <stdio.h>
#include <math.h>
 
int main(){

    int i, sum = 0;

    printf("Sum of Every Third Integer: ");
    for (i = 2; i <= 100; i+=3)
    {
        sum = sum + i;
    }
    printf("%d", sum);
    return 0;
}

