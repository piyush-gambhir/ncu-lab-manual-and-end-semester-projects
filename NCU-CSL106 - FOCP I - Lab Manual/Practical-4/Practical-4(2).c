#include <stdio.h>

int main (){ 
    
    char character;
    int ascii;
    printf("Enter a Character: ");
    scanf("%c", &character);
    ascii = character;
   
    printf("ASCII value of %c is: %d\n", character, ascii);

    int a;
    if (ascii >= 65 && ascii <= 90){
        a=1;
    }
    else if (ascii >= 97 && ascii <=122){
        a=2;
    }
    else if (ascii >=48 && ascii <= 57){
        a=3;
    }
    else if (ascii>=0 && ascii<=47 || ascii>=58 && ascii<=64 || ascii>=91 && ascii<=96 || ascii>=123 && ascii<=127){
        a=4;
    }

    switch(a){
        case(1): printf("%c is a Capital Letter");
            break;
        case(2): printf("%c is a Small Letter");
            break;
        case(3): printf("%c is a Number Character");
            break;
        case(4): printf("%c is a Special Character");
            break;
    }
    return 0;
}





