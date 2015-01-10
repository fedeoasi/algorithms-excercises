package com.github.fedeoasi.combinatorics;

public class CoinChange {
    static int count(int S[], int n) {

        int m = S.length;

        // We need n+1 rows as the table is constructed in bottom up manner using
        // the base case 0 value case (n = 0)
        int[][] table = new int[n + 1][m];

        // Fill the enteries for 0 value case (n = 0)
        for (int i = 0; i < m; i++) {
            table[0][i] = 1;
        }

        int x, y;
        // Fill rest of the table entries in bottom up manner
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                // Count of solutions including S[j]
                int t = i - S[j];
                x = (t >= 0) ? table[t][j] : 0;

                // Count of solutions excluding S[j]
                y = (j >= 1) ? table[i][j - 1] : 0;

                // total count
                table[i][j] = x + y;

                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        return table[n][m - 1];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2};
        System.out.println(count(coins, 4));
    }
}
