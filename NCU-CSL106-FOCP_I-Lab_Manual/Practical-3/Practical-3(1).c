#include<stdio.h>

int main(){
	
	int price, quantity, total_cost, expense;
	float discount;
	
	printf("Enter the Price of Item Purchased: ");
	scanf("%d", &price);
	printf("Enter the Quantitiy of Item Purchased: ");
	scanf("%d", &quantity);
	
	total_cost = price*quantity;
	
	if (quantity>1000){
		discount = 0.10;
		expense = total_cost - discount*total_cost;
		printf("Total Expense: %d", expense);
	}
	else{
		printf("Total Expense: %d", total_cost);
	}
	return 0;
}


