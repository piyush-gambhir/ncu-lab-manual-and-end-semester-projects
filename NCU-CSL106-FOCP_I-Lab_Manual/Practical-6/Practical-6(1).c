#include<stdio.h>

int main() {
    
    int num, i;
    int factorial = 1;
    printf("Enter Number: ");
    scanf("%d", &num);
    
    if(num>0);
    for(i=num; i>0; i--){
        factorial = factorial*i;
    }
    printf("Factorial of %d: %d", num, factorial);
    return 0;
}