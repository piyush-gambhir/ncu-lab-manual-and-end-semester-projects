#include <stdio.h>

int main()
{
    int num, count=0;

    printf("Enter a Positive Integer: ");
    scanf("%d", &num);

    for (int i=2; i<=num; i++){
        if (num%i == 0){
        count = 1;

        break;
        }
        else{
            continue;
        }
    }

    if (count==0){
        printf("\nThe Entered Number is a Prime Number.");
    }
    else{
        printf("\nThe Entered Number is Not a Prime Number.");
    }

    int a = 0;
    int b = 1;
    int c = a + b;
    
    while(c<num){
        a = b;
        b = c;
        c = a + b;
    }
    
    if (c == num)
    {
        printf("\nThe Entered Number is a Fibonaaci Number.");
    }
    else{
        printf("\nThe Entered Number is not a Fibonaaci Number.");
    }
    return 0;
}





