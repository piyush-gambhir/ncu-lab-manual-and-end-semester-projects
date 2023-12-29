#include <stdio.h>

int main()
{
    int x;
    printf("Enter the Size of the 1D Array: ");
    scanf("%d", &x);

    int array[x];

    int n;
    printf("Enter Position of Array Where You Want to Insert the Element: ");
    scanf("%d", &n);

    printf("Enter the Value You Want to Insert at %d Position of the Array: ", n);
    scanf("%d", &array[n-1]);

    for (int i = 0; i < x; i++)
    {
        printf("%d ", array[i]);
    }

    return 0;
}


