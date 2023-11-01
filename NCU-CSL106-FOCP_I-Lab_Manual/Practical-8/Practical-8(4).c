#include <stdio.h>

void printArr(int *arr, int size);

int main()
{
    int arr[MAX_SIZE];
    int size;
    int *left = arr; 
    int *right;

    printf("Enter Size of Array: ");
    scanf("%d", &size);

    right = &arr[size - 1]; 

    printf("Enter Elements in Array: ");
    while (left <= right)
    {
        scanf("%d", left++);
    }

    printf("\nArray before reverse: ");
    printArr(arr, size);

    left = arr;

    while (left < right)
    {
        *left ^= *right;
        *right ^= *left;
        *left ^= *right;

        left++;
        right--;
    }

    printf("\nArray After Reverse: ");
    printArr(arr, size);

    return 0;
}

void printArr(int *arr, int size)
{
    int *arrEnd = (arr + size - 1);

    while (arr <= arrEnd)
    {
        printf("%d, ", *arr);

        arr++;
    }
}

