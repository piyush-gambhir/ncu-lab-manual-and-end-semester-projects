#include <stdio.h>
int main()
{
    int num;
    int sum=0;
	do{
        printf("Enter a Number: ");
        scanf("%d", &num);
        sum += num;
    }
	while(num != 0);
 
    printf("Total Sum = %d",sum);
    return 0;
}
