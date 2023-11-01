#include<stdio.h>

int main() {  
    
    int a, b;
    printf("Enter First Number: ");
    scanf("%d", &a);
    printf("Enter Second Number: ");
    scanf("%d", &b);

    printf("\n\nEnter 1 For Addition.\n"); 
    printf("Enter 2 For Subtraction.\n"); 
    printf("Enter 3 For Multiplication.\n"); 
    printf("Enter 4 For Division.\n"); 
    
	int user_choice; 
	printf("\nEnter Your Choice: ");
	scanf("%d", &user_choice); 

    switch(user_choice){
        case 1: 
            printf("Addition : a+b = %d", a+b);
            break;
        case 2: 
            printf("Subtraction : a-b = %d", a-b);
            break;
        case 3: 
            printf("Multiplication : axb = %d", a*b);
            break;
        case 4: 
            printf("Division : a/b = %d", a/b);
            break;
        default: 
            printf("Invalid Choice!");
    }
    return 0;
}

