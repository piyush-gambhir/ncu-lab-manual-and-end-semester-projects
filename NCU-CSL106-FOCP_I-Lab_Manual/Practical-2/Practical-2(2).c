#include <stdio.h>
#include <math.h>

int main(){

    int num, temp;
    printf("Enter the Number: ");
    scanf("%d", &num);

    temp = num;
    int count = 0;
    do{
        temp /= 10;
        count++;
    } 
    while (temp != 0);

    int i, k;
    for (int i = count; i >= 1; i--){
        int k = pow(10, i);
        printf("%d ", num % k);
        printf("\n");
    }
    return 0;
}










