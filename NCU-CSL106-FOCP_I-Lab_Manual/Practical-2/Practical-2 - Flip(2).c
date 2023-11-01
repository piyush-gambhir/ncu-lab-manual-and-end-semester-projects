#include <stdio.h>

int main(){
	
	float km;              
	float miles;              
	     

	printf("Input Kilometers Per Hour: ");
	scanf("%f", &km);

	miles = (km * 0.6213712);
	printf("%f Miles Per Hour\n", miles);

	return(0);
}

