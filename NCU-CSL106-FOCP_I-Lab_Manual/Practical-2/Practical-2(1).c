#include<stdio.h>
int main() 
{ 
	float num; 
	int x; 
	printf("Enter the Floating Point Number: ");
	scanf("%f", &num); 
	x=(int)num; 
	printf("The Right Most Part of Floating Point Number: %d", x%10); 
	return 0; 
} 
