#include<stdio.h>

int main() {

    int num, i, pr;

    printf("Enter Number: ");
    scanf("%d", &num);
	 
    for(i=1; i<=10; i++){
        pr = num * i;
		printf("%d x %d  =  %d", num, i, pr);
		printf("\n");
    }
    return 0;
}



