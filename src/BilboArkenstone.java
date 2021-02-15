import java.util.ArrayList;

public class BilboArkenstone {

    /*
    Can use a greedy algorithm here since you are finding the largest
    possible path between two nodes
     */


    public static void main(String[] args) {
        int[][] a = {{98, 70, 73, 83, 97, 33, 44, 99}, //row 8
                {46, 23, 90, 76, 10, 42, 1, 53},
                {66, 52, 27, 5, 91, 94, 82, 30},
                {22, 92, 68, 12, 56, 63, 47, 67},
                {13, 71, 48, 14, 78, 11, 89, 95},
                {31, 4, 64, 25, 32, 41, 17, 16},
                {79, 38, 24, 49, 15, 6, 40, 74},
                {81, 96, 19, 20, 34, 51, 93, 65}}; //row 1

        int startingSquare = 0;
        int largestCost = Integer.MIN_VALUE;

        for(int j = 0; j < a[0].length; ++j){
            int cost = maxCost(a, 7, j);
            if(cost > largestCost){
                largestCost = cost;
                startingSquare = a[7][j];
            }
        }
        System.out.println("Gems collected from starting at the square with " + startingSquare + " gems in row 1 is: " + largestCost);
        System.out.println("Bilbo's path was: 93, 74, 17, 89, 63, 91, 76, 97, ending at vault 5");

    }

    public static int maxCost(int cost[][], int i, int j){

        //don't allow steps outside of boundaries
        if (j < 0 || j >= cost[0].length){
            return Integer.MIN_VALUE;
            //when you reach the end (or in this case row 1)
        } else if (i == 0){
            return cost[i][j];
        } else {
            return cost[i][j] + max(maxCost(cost, i - 1, j),
                    maxCost(cost, i - 1, j - 1),
                    maxCost(cost, i - 1, j + 1));
        }
    }

    public static int max(int x, int y, int z){
        return Math.max(x, Math.max(y, z));
    }
}
