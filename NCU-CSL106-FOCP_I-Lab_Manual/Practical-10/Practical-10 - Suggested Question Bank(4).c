#include <stdio.h>
#include <string.h>
void main()
{
    char str[50];
    char ch_o, ch_n;

    printf("Enter the String : ");
    gets(str);

    printf("\nEnter the Character You Want to Replace: ");
    ch_o = getchar();

    printf("\nEnter the Character You Want to Replace With: ");
    ch_n = getchar();

    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] == ch_o)
        {
            str[i] = ch_n;
        }
    }

    printf("\nString After Replacing %c by %c: %s", ch_o, ch_n, str);

}
