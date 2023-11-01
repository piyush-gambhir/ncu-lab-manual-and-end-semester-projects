#include<stdio.h>

int main() {
    
   int user_input, i, j, k, factorial=1;
   printf("Enter Number: ");
   scanf("%d", &user_input);
	
   for(i=1; i<=user_input; i++){
       printf("\n");
	   for(j=1; j<=i; j++){
    	printf("%d ", j);
	   }
   }
   
   if(user_input>0){
        printf("\n\nThe Entered Number is a Positive Natural Number.");
    }
   
   for(k=user_input; k>0; k--){
		factorial = factorial*k;
    }
	printf("\n\nFactorial of %d: %d", user_input, factorial);
   
    return 0;
}
