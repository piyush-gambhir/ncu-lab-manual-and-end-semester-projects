#include <stdio.h>

int swap(int *, int *);

int main()
{
    int a, b;
    
    printf("Enter the Value of a: ");
    scanf("%d", &a);
    printf("Enter the Value of b: ");
    scanf("%d", &b);
   
    printf("\n");
    printf("\nValue of a Before Swapping: %d", a);
    printf("\nValue of b Before Swapping: %d", b);

    printf("\n");
    swap(&a, &b);

    printf("\nValue of a After Swapping: %d", a);
    printf("\nValue of b After Swapping: %d", b);

    return 0;
}

int swap(int *x, int *y)
{
    int temp;

    temp = *y;
    *y = *x;
    *x = temp;

    return 0;
}





