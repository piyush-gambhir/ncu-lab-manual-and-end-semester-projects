#include<stdio.h>

int main()
{
    int age;
    printf("Enter the age of User: ");
    scanf("%d", &age);

	if (age > 18){
		printf("User is Eligible for Voting");
	}
	else{
		printf("User is Not Eligible for Voting");
	}	
    return 0;
}

