#include <stdio.h>
#include <string.h>

int main()
{
    char string[30];
    printf("\nEnter the String: ");
    scanf("%s", string);

    printf("\nOriginal String: %s", string);

    char string_copy[30];
    int i, j = 0;
    for (i = 0; string[i] != '\0'; i++)
    {
        string_copy[j] = string[i];
        j++;
    }
    printf("\nCopied String: %s", string_copy);
    return 0;
}








