#include <stdio.h>

int main()
{
    int m, n;
    printf("\nEnter the Number of Rows of the Matrix: ");
    scanf("%d", &m);
    printf("Enter the Number of Columns of the Matrix: ");
    scanf("%d", &n);
    printf("\nOrder of Matrix is %d x %d", m, n);
    printf("\n\n");

    int matrix[m][n];

    for (int i = 1; i <= m; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            printf("Enter the Value of the Elements [%d][%d]: ", i, j);
            scanf("%d", &matrix[i][j]);
        }
    }
    printf("The Matrix is:\n");
    for (int i = 1; i <= m; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    printf("The Transpose of the Matrix is:\n");
    for (int i = 1; i <= m; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            printf("%d ", matrix[j][i]);
        }
        printf("\n");
    }

    return 0;
}



