public class GaussJordanElimination {

    public static void main(String[] args) {
        float a[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 2, 1, 1, 1, 1, 2, 1, 0},
                {1, 1, 3, 1, 1, 3, 1, 1, 0},
                {1, 1, 1, 4, 4, 1, 1, 1, 0},
                {11, 1, 1, 1, 1, 1, 1, 1, 20},
                {1, 1, 1, 1, -1, -1, -1, -1, 34},
                {1, 2, 3, 4, 5, 6, 7, 8, -51},
                {1, -1, 1, -1, 1, -1, 1, -1, -6}};
        int n = a.length;

        reduceMatrix(a, n);
    }

    static void printMatrix(float a[][], int n){
        System.out.println("\nMatrix is: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    //put matrix in reduced row-echelon form using gauss-jordan elimination
    public static void reduceMatrix(float a[][], int n){
        int i, j, k = 0, c, m = 0;
        float pro = 0;

        //row operations
        for (i = 0; i < n; i++){
            if (a[i][i] == 0){
                c = 1;
                while ((i + c) < n && a[i + c][i] == 0)
                    c++;

                for (j = i, k = 0; k <= n; k++){
                    float temp =a[j][k];
                    a[j][k] = a[j+c][k];
                    a[j+c][k] = temp;
                }
            }

            for (j = 0; j < n; j++){
                //don't check the diagonals
                if (i != j){
                    //convert to diagonal matrix (1's along the diagonal)
                    float p = a[j][i] / a[i][i];
                    for (k = 0; k <= n; k++)
                        a[j][k] = a[j][k] - (a[i][k]) * p;
                }
            }
        }
        System.out.println("\nResults: ");
        for (i = 0; i < n; i++)
            System.out.println("x" + (i + 1) + " = " + a[i][n] / a[i][i]);
    }
}
