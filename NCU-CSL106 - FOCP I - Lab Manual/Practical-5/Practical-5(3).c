#include <stdio.h>
int main(){
    
	int sum=0;
    int i=0;
	while(i<10){
		sum = sum + i;
		i += 1;
	}
	printf("Total Sum = %d",sum);
    return 0;
}
