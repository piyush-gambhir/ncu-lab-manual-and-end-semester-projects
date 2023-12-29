#include <stdio.h>
#include <string.h>

int main()
{
    char string[30];
    printf("\nEnter the String: ");
    scanf("%s", string);

    printf("\nOrginal String: %s", string);
    printf("\nReversed String: %s", strrev(string)); 

    int value = strcmp(string, strrev(string));

    if (value == 0) 
    {
        printf("\nThe Entered Sting is Palindrome.");
    }
    else
    {
        printf("\nThe Entered Sting is Not Palindrome.");
    }
    return 0;
}



