#include <stdio.h>

int main()
{

    char ch;
    char *pch;
    pch = &ch;

    ch = 'H';

    printf("Value of ch: %c\n", ch);
    printf("Address of ch: %p\n", &ch);

    printf("Value of ch: %c\n", *pch);
    printf("Address of ch: %p", pch);
    return 0;
}



