#include<stdio.h>

int main(){
	int num, sum=0, rem, rev=0;
	
	printf("Enter a Positive Integer: ");
	scanf("%d",&num);
	
	int temp = num;

	while(num>0){
	sum = sum + num%10;
	rem = num%10;
	rev = rev * 10 + rem;
	num = num/10;
	}

	printf("Sum of Digits: %d", sum);

	if(rev == temp) { 
		printf("\nThe Given Number is a Palindrome Number.");
	}
	else {
		printf("\nThe Given Number is not a Palindrome Number.");
	}
	return 0;
}





