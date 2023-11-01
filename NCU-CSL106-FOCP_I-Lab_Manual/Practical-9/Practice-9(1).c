#include <stdio.h>

int main()
{
    int x;
    printf("Enter the Size of the 1D Array: ");
    scanf("%d", &x);

    int array[x];
    printf("Enter %d Values of Array: ", x);

    for (int i = 0; i < x; i++)
    {
        scanf("%d", &array[i]);
    }

    int largest = array[0];

    for (int i = 1; i < x; i++)
    {
        if (largest < array[i])
        {
            largest = array[i];
        }
    }
    printf("\nLargest Element Present in the Given Array = %d", largest);
    return 0;
}




