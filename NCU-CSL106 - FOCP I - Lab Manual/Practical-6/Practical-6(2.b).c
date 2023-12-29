#include<stdio.h>

int main() {
    
   int i, j;
	
   for(i=5; i>0; i--){
       printf("\n");
	   for(j=i; j>0; j--){
    	printf("%d ", i);
	   }
   }
   return 0;
}

