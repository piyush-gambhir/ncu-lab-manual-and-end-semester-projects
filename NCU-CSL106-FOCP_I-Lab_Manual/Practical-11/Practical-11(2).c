#include <stdio.h>

void main()
{
    struct library
    {
        int book_accession_number;
        char author_name[50];
        char book_title[50];
        char flag[10];
    };

    printf("Enter 1 to Display Book Information.");
    printf("Enter 2 to Add New Book.");
    printf("Enter 3 to Display all the Number of Books of a Particular Title.");
    printf("Enter 4 to Display the Number of Books of a Particular Title.");
    printf("Enter 5 to Display The Total Number of Books in the Library.");
    printf("Enter 6 to Issue a Book.");

    int user_choice;
    printf("Enter Your Choice: ");
    scanf("%d", user_choice);

    switch (user_choice)
    {
    case 1:
        printf("Enter Accession Number of Book: ");
        scanf("%s", &library.book_accession_number);
        break;

    case 2:
        printf("Enter the Accession Number: ");
        scanf("%s", &library.book_accession_number);
        printf("Enter the Author of the Book: ");
        scanf("%s", &library.author_name);
        printf("Enter the Book Title: ");
        scanf("%s", &library.book_title);
        break;

    case 3:
        

    }
}
