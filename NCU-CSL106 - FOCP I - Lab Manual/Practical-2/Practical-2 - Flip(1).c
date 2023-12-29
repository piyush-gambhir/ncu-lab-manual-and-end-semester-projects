# include <stdio.h>
int main(){
    
    int a,b,c,i,j,k;
    printf("Printing E With Dollar($) Sign");

    printf("\n\nEnter the Height: ");
    scanf("%d", &a);
    printf("\nEnter Both Width: ");
    scanf("%d %d", &b, &c);
    
    printf("\n\n");

    for(i=0;i<a;i++){
        if(i==0 || i==a-1){
            for(j=0;j<b;j++){
                printf("$");
            }
        }
        else if(i==a/2 || i==(a-1)/2){
            for(j=0;j<c;j++){
                printf("$");
            }        
        }
        else{
            printf("$");
            printf("\n");
        }
    }   
    return 0;
}




