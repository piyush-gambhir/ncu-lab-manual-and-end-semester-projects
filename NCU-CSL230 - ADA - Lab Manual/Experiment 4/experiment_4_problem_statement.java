









public class experiment_4_problem_statement {


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Invalid Input");
            return;
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }



    public static int[][] subtractMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }



    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }



    public static int[][] StrassenMatrixAlgorithm(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Invalid Input");
            return null;
        }

        int[][] result = new int[matrix1.length][matrix2[0].length];


        if (matrix1.length == 1) {
            result[0][0] = matrix1[0][0] * matrix2[0][0];
            return result;
        }


        int[][] a11 = new int[matrix1.length / 2][matrix1.length / 2];
        int[][] a12 = new int[matrix1.length / 2][matrix1.length / 2];
        int[][] a21 = new int[matrix1.length / 2][matrix1.length / 2];
        int[][] a22 = new int[matrix1.length / 2][matrix1.length / 2];

        int[][] b11 = new int[matrix2.length / 2][matrix2.length / 2];
        int[][] b12 = new int[matrix2.length / 2][matrix2.length / 2];
        int[][] b21 = new int[matrix2.length / 2][matrix2.length / 2];
        int[][] b22 = new int[matrix2.length / 2][matrix2.length / 2];


        for (int i = 0; i < matrix1.length / 2; i++) {
            for (int j = 0; j < matrix1.length / 2; j++) {
                a11[i][j] = matrix1[i][j];
                a12[i][j] = matrix1[i][j + matrix1.length / 2];
                a21[i][j] = matrix1[i + matrix1.length / 2][j];
                a22[i][j] = matrix1[i + matrix1.length / 2][j + matrix1.length / 2];
            }
        }


        for (int i = 0; i < matrix2.length / 2; i++) {
            for (int j = 0; j < matrix2.length / 2; j++) {
                b11[i][j] = matrix2[i][j];  
                b12[i][j] = matrix2[i][j + matrix2.length / 2];
                b21[i][j] = matrix2[i + matrix2.length / 2][j];
                b22[i][j] = matrix2[i + matrix2.length / 2][j + matrix2.length / 2];
            }
        }


        int[][] p1 = StrassenMatrixAlgorithm(a11, subtractMatrix(b12, b22));
        int[][] p2 = StrassenMatrixAlgorithm(addMatrix(a11, a12), b22);
        int[][] p3 = StrassenMatrixAlgorithm(addMatrix(a21, a22), b11);
        int[][] p4 = StrassenMatrixAlgorithm(a22, subtractMatrix(b21, b11));
        int[][] p5 = StrassenMatrixAlgorithm(addMatrix(a11, a22), addMatrix(b11, b22));
        int[][] p6 = StrassenMatrixAlgorithm(subtractMatrix(a12, a22), addMatrix(b21, b22));
        int[][] p7 = StrassenMatrixAlgorithm(subtractMatrix(a11, a21), addMatrix(b11, b12));


        int[][] c11 = addMatrix(subtractMatrix(addMatrix(p5, p4), p2), p6);
        int[][] c12 = addMatrix(p1, p2);
        int[][] c21 = addMatrix(p3, p4);
        int[][] c22 = subtractMatrix(subtractMatrix(addMatrix(p5, p1), p3), p7);


        for (int i = 0; i < result.length / 2; i++) {
            for (int j = 0; j < result.length / 2; j++) {
                result[i][j] = c11[i][j];
                result[i][j + result.length / 2] = c12[i][j];
                result[i + result.length / 2][j] = c21[i][j];
                result[i + result.length / 2][j + result.length / 2] = c22[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] matrix1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        System.out.println("Matrix 1 : ");
        printMatrix(matrix1);
        System.out.println();

        System.out.println("Matrix 2 : ");
        printMatrix(matrix2);
        System.out.println();

        System.out.println("Matrix Multiplication : ");
        multiplyMatrix(matrix1, matrix2);
        System.out.println();

        System.out.println("Strassen's Matrix Algorithm : ");
        printMatrix(StrassenMatrixAlgorithm(matrix1, matrix2));
    }
}