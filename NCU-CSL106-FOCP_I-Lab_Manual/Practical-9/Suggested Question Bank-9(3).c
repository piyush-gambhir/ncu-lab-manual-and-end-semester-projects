#include <stdio.h>

int main()
{
    int n1, n2, n3;
    printf("\nEnter the Size of First Array: ");
    scanf("%d", &n1);
    printf("\nEnter the Size of Second Array: ");
    scanf("%d", &n2);

    n3 = n1 + n2;
    int a[n1], b[n2], c[n3];

    printf("\nEnter The Elements of First Array: ");
    for (int i = 0; i < n1; i++)
    {
        scanf("%d", &a[i]);
    }

    for (int i = 0; i < n1; i++)
    {
        for (int j = i + 1; j < n1; j++)
        {
            if (a[i] > a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    int k = n1;
    printf("\nEnter The Elements of Second Array: ");
    for (int i = 0; i < n2; i++)
    {
        scanf("%d", &b[i]);
    }

    for (int i = 0; i < n2; i++)
    {
        for (int j = i + 1; j < n2; j++)
        {
            if (b[i] > b[j])
            {
                int temp = b[i];
                b[i] = b[j];
                b[j] = temp;
            }
        }
    }

    for (int i = 0; i < n1; i++)
    {
        c[i] = a[i];
    }
    for (int j = 0; j < n2; j++)
    {
        c[k] = b[j];
        k++;
    }
    
    printf("\nMerged Array: \n");
    for (int i = 0; i < n3; i++)
    {
        printf(" %d ", c[i]);
    }

    return 0;
}



