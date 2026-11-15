






import java.util.*;




public class experiment_8_problem_statement {

    static int tsp(int[][] cost, int[] tour, int start, int n) {
        int[] temp = new int[n];
        int[] mintour = new int[n];
        int mincost = Integer.MAX_VALUE;
        int ccost;
        if (start == n - 2) {
            return cost[tour[n - 2]][tour[n - 1]] + cost[tour[n - 1]][0];
        }
        for (int i = start + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j] = tour[j];
            }
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];
            if (cost[tour[start]][tour[i]] + (ccost = tsp(cost, temp, start + 1, n)) < mincost) {
                mincost = cost[tour[start]][tour[i]] + ccost;
                for (int j = 0; j < n; j++) {
                    mintour[j] = temp[j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            tour[i] = mintour[i];
        }
        return mincost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cities: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        System.out.println("Enter the cost matrix: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the cost for city " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        int[] tour = new int[n];
        for (int i = 0; i < n; i++) {
            tour[i] = i;
        }
        int minCost = tsp(cost, tour, 0, n);
        System.out.println("Minimum cost: " + minCost);
        sc.close();
    }
}