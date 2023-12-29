#include <stdio.h>
#include <string.h>

int main()
{
    char str[100], ch;
    int i, len, j;

    printf("\nPlease Enter any String :  ");
    gets(str);

    printf("Please Enter the Character that you Want to Remove : ");
    scanf("%c", &ch);

    len = strlen(str);

    for (i = 0; i < len; i++)
    {
        if (str[i] == ch)
        {
            for (j = i; j < len; j++)
            {
                str[j] = str[j + 1];
            }
            len--;
            i--;
        }
    }
    printf("\nThe Final String After Removing All Occurrences of '%c' = %s ", ch, str);
 
    return 0;
}




