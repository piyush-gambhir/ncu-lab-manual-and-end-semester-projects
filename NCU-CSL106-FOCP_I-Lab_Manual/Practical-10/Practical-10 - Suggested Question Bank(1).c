#include <stdio.h>
void main()
{
    char string[20];
    int n, count = 0;

    printf("Enter The Number of Characters Present in an Array: ");
    scanf("%d", &n);

    printf("Enter the String of %d Characters: ", n);
    scanf("%s", string);

    while (count < n)
    {
        printf("\nASCII Value of %c = %d", string[count], string[count]);
        ++count;
    }
}



