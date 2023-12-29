#include <stdio.h>

void main()
{
    int x;
    printf("\nEnter the Size of Array: ", x);
    scanf("%d", &x);

    int array[x];

    printf("\nEnter the Elements of the Array: ");
    for (int i = 0; i < x; i++)
    {
        scanf("%d", &array[i]);
    }

    int odd_array[x], even_array[x];
    int j = 0, k = 0;

    for (int i = 0; i < x; i++)
    {
        if (array[i] % 2 == 0)
        {
            even_array[j] = array[i];
            j++;
        }
        else
        {
            odd_array[k] = array[i];
            k++;
        }
    }
    printf("\nThe Elements of Even Array are: ");
    for (int i = 0; i < j; i++)
    {
        printf("%d ", odd_array[i]);
    }

    printf("\nThe Elements of Odd Array are: ");
    for (int i = 0; i < k; i++)
    {
        printf("%d ", even_array[i]);
    }
}


