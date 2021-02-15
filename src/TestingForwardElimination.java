public class TestingForwardElimination {

    /*
    1. The ForwardElimination algorithm fails to provide a solution for this specific matrix because row 2 column 2 turns to 0, and the program tries to pivot around this, which is not possible.

    BetterForwardElimination remedies this problem by checking the pivot to make sure it is not 0. If the pivot is zero the program thinks the array is unsolveable since there is no way to reduce other rows using a coefficient of 0, so BetterForwardElimination simpy selects a different row to use as the pivot. Additionally, by not having a temp variable in ForwardElimination, then you reset A[1][0] for example each time you do a calculation, which messes up the calculations for further elements in the matrix. This is why BetterForwardElimination has a temporary variable for the division step.

    2. the BetterForwardElimination algorithm has trouble with this specific matrix since there are infinite solutions. It correctly reduces the rows so that rows 2 and 3 are identical, but it can not discern that this means there is a free variable. To improve this shortcoming, we would need to check whether or not two rows are multiples of each other, and if they are, break out of the function and print that there are infinite solutions.
     */



    public static void main(String[] args) {
        int[][] A = {{1, 1, 1, 0},
                {1, 1, 2, 0},
                {2, 2, 3, 0}};
        int[] b = {6, 9, 15};

        printMatrix(A);

        betterForwardElimination(A, b);

        printMatrix(A);

    }

    public static void betterForwardElimination(int[][] A, int[] b){
        int n = A.length;
        int pivotRow = 0;

        //augment matrix
        for(int i = 0; i < n; ++i){
            A[i][n] = b[i];
        }

        for(int i = 0; i < n - 1; ++i){
            pivotRow = i;
            System.out.println("Pivot row is " + pivotRow);
            printMatrix(A);
            for(int j = i + 1; j < n; ++j){
                if(A[j][i] > A[pivotRow][i]) pivotRow = j;
                System.out.println("NEW pivot row is " + pivotRow);
                int temp = (A[j][i]/A[i][i]);
                for(int k = i; k < n + 1; ++k){

                    System.out.println("A[" + j + "][" + k + "] -= " + "A[" + i + "][" + k + "] * (A[" + j + "][" + i + "]/A[" + i + "][" + i + "])");
                    System.out.println(A[j][k] + "=" + A[j][k] + "-" + "(" + A[i][k] + "* (" + temp + "))");

                    A[j][k] = A[j][k] - (A[i][k] * temp);
                }
            }

        }
    }

    public static void printMatrix(int[][] A){
        System.out.println("Matrix A: ");
        for(int i = 0; i < A.length; ++i){
            for(int j = 0; j < A[0].length; ++j){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
