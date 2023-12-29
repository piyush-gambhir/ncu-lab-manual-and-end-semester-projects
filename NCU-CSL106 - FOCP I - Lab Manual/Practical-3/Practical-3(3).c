#include<stdio.h>
#include<conio.h>
int main()
{
    int a, b, c, sum_angles;
    printf("Enter Angles of the Triangle: ");
    scanf("%d %d %d", &a, &b, &c);
    sum_angles = a+b+c;

    if (sum_angles = 180){
        printf("Triangle is Valid");
	}
    else{
        printf("Triangle is Not Valid");
	}
    return 0;
}



