import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter number of rows and columns for the matrices: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        
        System.out.println("Enter elements of Matrix 1:");
        readMatrix(scanner, matrix1);
        
        System.out.println("Enter elements of Matrix 2:");
        readMatrix(scanner, matrix2);
        
        System.out.println("Addition:");
        printMatrix(addMatrices(matrix1, matrix2));
        
        System.out.println("Subtraction:");
        printMatrix(subtractMatrices(matrix1, matrix2));
        
        System.out.println("Multiplication:");
        printMatrix(multiplyMatrices(matrix1, matrix2));
        
        scanner.close();
    }
    
    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    
    private static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    private static int[][] subtractMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    private static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int commonDim = a[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < commonDim; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}