#include<stdio.h>
int main(){

   double score_1, score_2, score_3, score_4, score_5;

   printf("Enter Score(0-100): Subjetc 1: ");
   scanf("%lf", &score_1);
   printf("Enter Score(0-100): Subjetc 2: ");
   scanf("%lf", &score_2);
   printf("Enter Score(0-100): Subjetc 3: ");
   scanf("%lf", &score_3);
   printf("Enter Score(0-100): Subjetc 4: ");
   scanf("%lf", &score_4);
   printf("Enter Score(0-100): Subjetc 5: ");
   scanf("%lf", &score_5);

   double total_score = score_1 + score_2 + score_3 + score_4 + score_5;
   int score = total_score/5;

   printf("\n");
   switch(score/10){
   case 10:
      printf("Grade: A");
      break;
   case 9:
      printf("Grade: A");
      break;
   case 8:
      printf("Grade: B");
      break;
   case 7:
      printf("Grade: C");
      break;
   case 6:
      printf("Grade: D");
      break;
   case 5:
      printf("Grade: E");
      break;
   default:
      printf("Grade: F");
      break;
   }
   return 0;
   }







