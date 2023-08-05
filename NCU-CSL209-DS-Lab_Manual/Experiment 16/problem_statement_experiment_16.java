/*

Problem Statement

Write a program to implement:
1. Bubble Sort 
2. Insertions Sort 
3. Selection Sort
4. Quick Sort
5. Merge Sort

*/

/**
 * problem_statement_experiment_16
 */
public class problem_statement_experiment_16 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Given Array");
        printArray(arr);

        bubbleSort(arr);
        System.out.println("Bubble Sort");
        printArray(arr);

        System.out.println();

        int[] arr1 = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Given Array");
        printArray(arr);

        insertionSort(arr1);
        System.out.println("Insertion Sort");
        printArray(arr1);

        System.out.println();

        int[] arr2 = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Given Array");
        printArray(arr);

        selectionSort(arr2);
        System.out.println("Selection Sort");
        printArray(arr2);

        System.out.println();

        int[] arr3 = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Given Array");
        printArray(arr);

        quickSort(arr3, 0, arr3.length - 1);
        System.out.println("Quick Sort");
        printArray(arr3);

        System.out.println();

        int[] arr4 = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Given Array");
        printArray(arr);

        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("Merge Sort");
        printArray(arr4);

    }
}