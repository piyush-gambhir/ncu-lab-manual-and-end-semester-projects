#include <stdio.h>
#include <string.h>

int main()
{
    char string[50];
    printf("\nEnter the String: ");
    scanf("%s", string);

    printf("\nOriginal String: %s", string);

    for (int i = 0; string[i] != '\0'; i++)
    {

        if (string[i] >= 'a' && string[i] <= 'z')
        {
            string[i] = string[i] - 32;
        }
    }
    printf("\nUppercase string : %s", string);

    return 0;
}




