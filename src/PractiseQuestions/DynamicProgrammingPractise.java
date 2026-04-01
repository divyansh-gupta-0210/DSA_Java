package PractiseQuestions;

import java.util.Arrays;

public class DynamicProgrammingPractise {

    public static void main(String[] args) {
//        int n = 5;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        print(fibonacci(n, dp));

//        int[] path = {30,10,60,10,60,50};
//        int[] dp = new int[path.length + 1]; Arrays.fill(dp, -1);
//        print(frogJumps(path, dp, path.length - 1));
//        print(frogKJumps(path, dp, path.length - 1, 3));
//        print(Arrays.toString(dp));

//        int[] arr = {2, 1, 4, 9};
//        int[] dp = new int[arr.length + 1]; Arrays.fill(dp, -1);
//        print(maximumSumOfNonAdjEle(arr, dp, arr.length - 1));
//        print(houseRobber(arr, dp, arr.length - 1));   // Circular -> Last house links the 1st

//         int[][] arr = {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
//         int[][] dp = new int[arr.length][4];
//         for(int i = 0;  i < arr.length; i++){
//             Arrays.fill(dp[i], -1);
//         }
//         print(ninjasTraining(arr, dp, arr.length - 1, 0));

//        int[][] grid = new int[3][3];
//        int[][] dp = new int[3][3];
//        for(int i = 0;  i < dp.length; i++){
//             Arrays.fill(dp[i], -1);
//        }
//        print(uniquePaths(grid, dp, grid.length-1, grid[0].length - 1));
//        int[][] grid = {{0,0,0},{0,-1,0},{0,0,0}};
//        int[][] dp = new int[grid.length][grid[0].length];
//        for(int i = 0; i < dp.length; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(gridMazeObstacles(grid, dp, grid.length, grid[0].length));

//        int[][] grid = {{10,8,2},{10,5,100},{1,1,2}};
//
//        int[][] dp = new int[grid.length][grid[0].length];
//        for(int i = 0; i < dp.length; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(minimumPathSum(grid, dp, grid.length - 1, grid[0].length - 1));

//        int[][] grid = {{1},{2,3},{3,6,7},{8,9,6,10}};
//
//        int[][] dp = new int[grid.length][];
//        for (int i = 0; i < grid.length; i++) {
//            dp[i] = new int[grid[i].length];
//            Arrays.fill(dp[i], -1);
//        }
//        print(triangleFixedStartingAndVariableEndingPoint(grid, dp, 0, 0));

//        int[][] grid = {
//                {1,2,10,4},
//                {100,3,2,1},
//                {1,1,20,2},
//                {1,2,2,1}};
//        int[][] dp = new int[grid.length][];
//        for (int i = 0; i < grid.length; i++) {
//            dp[i] = new int[grid[i].length];
//            Arrays.fill(dp[i], -1);
//        }
//        int max = Integer.MIN_VALUE;
//        for (int j = 0; j < grid[0].length; j++) {
//            max = Math.max(max, minimumMaximumFallingPathSum(grid, dp, grid.length - 1, j));
//        }
//        print(minimumMaximumFallingPathSum(grid, dp, grid.length - 1, grid[0].length - 1));
//        System.out.println(max);

        int[][] grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }

        System.out.println(cherryPickUp(grid, dp, 0, 0, m - 1));
    }

    public static int cherryPickUp(int[][] grid, int[][][] dp, int i, int j1, int j2){
        int n = grid.length;
        int m = grid[0].length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += cherryPickUp(grid, dp, i + 1, j1 + dj1, j2 + dj2);

                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public static int minimumMaximumFallingPathSum(int[][] grid, int[][] dp, int row, int col){

        int[] prev = new int[grid.length];

        for(int i = 0; i < grid.length; i++){
            prev[i] = grid[0][i];
        }

        for(int i = 1; i < grid.length; i++){
            int[] curr = new int[grid.length];
            for(int j = 0; j < grid[0].length; j++){
                int up = grid[i][j] + prev[j];
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;
                if(j - 1 >= 0){
                    ld = grid[i][j] + prev[j - 1];
                }
                if(j + 1 < grid.length){
                    rd = grid[i][j] + prev[j + 1];
                }
                curr[j] = Math.max(up, Math.max(ld, rd));
            }

            prev = curr;
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < grid.length; j++) {
            max = Math.max(max, prev[j]);
        }
        return max;

//        Tabulation
//        for(int j = 0; j < grid.length ; j++){
//            dp[0][j] = grid[0][j];
//        }
//
//        for(int i = 1; i < grid.length; i++){
//            for(int j = 0; j < grid[i].length; j++){
//                int ld = Integer.MIN_VALUE; int rd = Integer.MIN_VALUE;
//                int up = grid[i][j] + dp[i-1][j];
//                if(j - 1 >= 0) ld = grid[i][j] + dp[i-1][j-1];
//                if(j + 1 < grid.length) rd = grid[i][j] + dp[i-1][j+1];
//                dp[i][j] = Math.max(up, Math.max(ld, rd));
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        for (int j = 0; j < grid[0].length; j++) {
//            max = Math.max(max, dp[grid.length - 1][j]);
//        }
//        print(Arrays.toString(dp[dp.length-1]));
//        return max;

//        Brute and Better
//        if(col < 0 || col >= grid[0].length){
//            return Integer.MIN_VALUE;
//        }
//        if(row == 0){
//            return grid[0][col];
//        }
//        if(dp[row][col] != -1) return dp[row][col];
//        int up = grid[row][col] + minimumMaximumFallingPathSum(grid, dp, row - 1, col);
//        int rightDi = grid[row][col] + minimumMaximumFallingPathSum(grid, dp, row - 1, col + 1);
//        int leftDi = grid[row][col] + minimumMaximumFallingPathSum(grid, dp, row - 1, col - 1);
//        return dp[row][col] = Math.max(up, Math.max(rightDi, leftDi));
    }

    public static int triangleFixedStartingAndVariableEndingPoint(int[][] grid, int[][] dp, int row, int col){

//        Space Optimization
        int[] prev = new int[grid[grid.length - 1].length];
        for (int j = 0; j < grid[grid.length - 1].length; j++) {
            prev[j] = grid[grid.length - 1][j];
        }
        for(int i = grid.length - 2; i >= 0; i--){
            int[] curr = new int[i+1];
            for(int j = 0; j <= i; j++){
                int down = grid[i][j] + prev[j];
                int dai = grid[i][j] + prev[j+1];
                curr[j] = Math.min(dai, down);
            }
            prev = curr;
        }
        return prev[0];

//        Tabulation
//        for (int j = 0; j < grid[grid.length - 1].length; j++) {
//            dp[grid.length - 1][j] = grid[grid.length - 1][j];
//        }
//
//        for(int i = grid.length - 2; i >= 0; i--){
//            for (int j = 0; j <= i; j++){
//                int down = grid[i][j] + dp[i+1][j];
//                int dia = grid[i][j] + dp[i+1][j+1];
//                dp[i][j] = Math.min(down, dia);
//            }
//        }
//        return dp[0][0];

//        Brute + Better
//        if(row == grid.length - 1){
//            return grid[row][col];
//        }
//        if (dp[row][col] != -1) return dp[row][col];
//        int down = grid[row][col] + triangleFixedStartingAndVariableEndingPoint(grid, dp, row + 1, col);
//        int diagonal = grid[row][col] + triangleFixedStartingAndVariableEndingPoint(grid, dp, row + 1, col + 1);
//        return dp[row][col] = Math.min(down, diagonal);
    }

    public static int minimumPathSum(int[][] grid, int[][] dp, int row, int col){

        int[] prev = new int[col + 1];

        for(int i = 0; i <= row; i++){
            int[] curr = new int[col + 1];
            for(int j = 0; j <= col; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if(i > 0) up = prev[j] + grid[i][j];
                    if(j > 0) left = curr[j - 1] + grid[i][j];

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[col];
        
//        Tabulation
//        for(int i = 0; i <= row; i++){
//            for(int j = 0; j <= col; j++){
//                if(i == 0 && j == 0){
//                    dp[i][j] = grid[0][0];
//                }
//                else{
//                    int up = Integer.MAX_VALUE;
//                    int left = Integer.MAX_VALUE;
//                    if(i > 0) up = grid[i][j] + dp[i-1][j];
//                    if(j > 0) left = grid[i][j] + dp[i][j-1];
//                    dp[i][j] = Math.min(up, left);
//                }
//            }
//        }
//        return dp[row][col];

//        if(row == 0 && col == 0){
//            return grid[0][0];
//        }
//        if(row < 0 || col < 0){
//            return Integer.MAX_VALUE;
//        }
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//        int up = minimumPathSum(grid, dp, row - 1, col);
//        int left = minimumPathSum(grid, dp, row, col-1);
//
//        if(up != Integer.MAX_VALUE) up += grid[row][col];
//        if(left != Integer.MAX_VALUE) left += grid[row][col];
//
//        return dp[row][col] = Math.min(up, left);
    }

    public static int gridMazeObstacles(int[][] grid, int[][] dp, int row, int col){

//      Optimal - Space Optimization
        int[] prev = new int[row];
        for(int i = 0; i < row; i++){
            int[] curr = new int[row];
            for(int j = 0; j < col; j++){
                int up = 0, left = 0;
                if(grid[i][j] == -1){
                    curr[j] = 0;
                }
                else if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else{
                    if(i > 0){
                        up = prev[j];
                    }
                    if(j > 0){
                        left = curr[j - 1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[grid.length-1];

//        Optimal - Tabulation
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                if(grid[i][j] == -1){
//                    dp[i][j] = 0;
//                    continue;
//                }
//                if(i == 0 && j == 0){
//                    dp[i][j] = 1;
//                    continue;
//                }
//                int up = 0;
//                int left = 0;
//                if(i > 0) up = dp[i-1][j];
//                if(j > 0) left = dp[i][j-1];
//                dp[i][j] = up + left;
//            }
//        }
//
//        return dp[row - 1][col - 1];

//        Better and Brute
//        if(row >= 0 && col >= 0 && grid[row][col] == -1){
//            return 0;
//        }
//        if(row == 0 && col == 0){
//            return 1;
//        }
//        if(row < 0 || col < 0){
//            return 0;
//        }
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//        int up = gridMazeObstacles(grid, dp, row -1, col);
//        int left = gridMazeObstacles(grid, dp, row, col - 1);
//        return dp[row][col] = up + left;
    }

    public static int uniquePaths(int[][] grid, int[][] dp, int row, int col){

//        Optimal
        int[] prev = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            int[] curr = new int[grid.length];
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else{
                    int up = 0, left = 0;
                    if(i > 0){
                        up = prev[j];
                    }
                    if(j > 0){
                        left = curr[j-1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[grid[0].length-1];

//        Tabulation
//        dp[0][0] = 1;
//        for(int i = 0; i < grid.length; i++){
//            for(int j = 0; j < grid[0].length; j++){
//                if(i == 0 && j == 0){
//                    dp[0][0] = 1;
//                }
//                else{
//                    int up = 0, left = 0;
//                    if(i > 0){
//                        up = dp[i-1][j];
//                    }
//                    if(j > 0){
//                        left = dp[i][j-1];
//                    }
//                    dp[i][j] = up + left;
//                }
//            }
//        }
//        return dp[grid.length-1][grid[0].length-1];

//        Brute + Better
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        if(i == 0 && j == 0){
//            return dp[i][j] = 1;
//        }
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//        int up = uniquePaths(grid, dp, i-1, j);
//        int left = uniquePaths(grid, dp, i, j-1);
//        return dp[i][j] = up + left;
    }

    public static int ninjasTraining(int[][] arr, int[][] dp, int day, int last){

//        Space Optimized
        int[] prev = new int[4];
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));


        for(int i = 1; i < arr.length; i++){
            int[] temp = new int[4];

            for(int j = 0; j < 4; j++){
                temp[j] = 0;

                for(int task = 0; task < 3; task++){
                    if(task != j){
                        temp[j] = Math.max(arr[i][task] + prev[task], temp[j]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];


//        Optimal
//        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
//        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
//        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
//        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
//
//        for(int i = 1; i < arr.length; i++){
//            for(int j = 0; j < 4; j++){
//                dp[i][j] = 0;
//                for(int task = 0; task < 3; task++){
//                    if(task != j){
//                        dp[i][j] = Math.max(arr[i][task] + dp[i-1][task], dp[i][j]);
//                    }
//                }
//            }
//        }
//
//        return dp[arr.length-1][3];

//        Brute and Better
//        if(day == 0){
//            int maxi = 0;
//            for(int i = 0; i < 3; i++){
//                if(i != last){
//                    maxi = Math.max(maxi, arr[0][i]);
//                }
//            }
//            return dp[day][last] = maxi;
//        }
//        if(dp[day][last] != -1){
//            return dp[day][last];
//        }
//        int maxi = 0;
//        for(int i = 0; i < 3; i++){
//            if(i != last){
//                int points = arr[day][i] + ninjasTraining(arr, dp, day - 1, i);
//                maxi = Math.max(points, maxi);
//            }
//        }
//        return dp[day][last] = maxi;
    }

    public static int houseRobber(int[] arr, int[] dp, int ind){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for(int i = 0; i < n - 1; i++){
            temp1[i] = arr[i + 1];
            temp2[i] = arr[i];
        }

        return Math.max(maximumSumOfNonAdjEle(temp1, dp, 0), maximumSumOfNonAdjEle(temp2, dp, 0));
    }

    public static int maximumSumOfNonAdjEle(int[] arr, int[] dp, int ind){

//        Optimal
        int prev = arr[0];
        int prev2 = 0;
        for(int i = 0; i < arr.length; i++){
            int take = arr[i];
            if(i>1){
                take+=prev2;
            }
            int notTake = prev2;
            int cur_i = Math.max(take, notTake);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;

//        Better
//        dp[0] = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            int take = arr[i];
//            if(i > 1){
//                take += dp[i-2];
//            }
//            int notTake = dp[i-1];
//            dp[i] = Math.max(take, notTake);
//        }
//        return dp[arr.length - 1];

//        Better and Brute
//        if(ind == 0){
//            return arr[ind];
//        }
//        if(ind < 0){
//            return 0;
//        }
//        if(dp[ind] != -1){
//            return dp[ind];
//        }
//        int pick = arr[ind] + maximumSumOfNonAdjEle(arr, dp, ind - 2);
//        int not_pick = maximumSumOfNonAdjEle(arr, dp, ind-1);
//        return dp[ind] = Math.max(pick, not_pick);
    }

    public static int frogKJumps(int[] path, int[] dp, int ind, int k){

//        Optimal
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < path.length; i++){
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(path[i] - path[i-j]));
                }
            }
        }
        return dp[path.length-1];
//        Better + Brute
//        if(ind == 0){
//            return dp[0] = 0;
//        }
//
//        if(dp[ind]!=-1){
//            return dp[ind];
//        }
//
//        int minSteps = Integer.MAX_VALUE;
//        for(int i = 1; i <= k; i++){
//            if(ind - i >= 0){
//                int jump = frogKJumps(path, dp, ind - i, k) + Math.abs(path[ind] - path[ind - i]);
//                minSteps = Math.min(minSteps, jump);
//            }
//        }
//        return dp[ind] = minSteps;
    }

    public static int frogJumps(int[] path, int[] dp, int ind){

//        Optimal
        int prev = 0; int prev2 = 0;
        int ss = Integer.MAX_VALUE;
        for(int i = 1; i < path.length; i++){
            int fs = prev + Math.abs(path[i] - path[i-1]);
            if(i > 1){
                ss = prev2 + Math.abs(path[i] - path[i-2]);
            }
            int cur_i = Math.min(fs, ss);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;

//        Better
//        dp[0] = 0;
//        int ss = Integer.MAX_VALUE;
//        for(int i = 1; i < path.length; i++){
//            int fs = dp[i-1] + Math.abs(path[i] - path[i-1]);
//            if(i > 1){
//                ss = dp[i-2] + Math.abs(path[i] - path[i-2]);
//            }
//            dp[i] = Math.min(fs, ss);
//        }
//        return dp[path.length-1];

//        Brute
//        if(ind == 0){
//            return dp[ind] = 0;
//        }
//        if(dp[ind] != -1){
//            return dp[ind];
//        }
//        int left = frogJumps(path, dp, ind - 1) + Math.abs(path[ind] - path[ind - 1]);
//        int right = Integer.MAX_VALUE;
//        if(ind > 1){
//            right = frogJumps(path, dp, ind - 2) + Math.abs(path[ind] - path[ind - 2]);
//        }
//        return dp[ind] = Math.min(left, right);
    }

    public static int fibonacci(int n, int[] dp){

        int prev2 = 0;
        int prev1 = 1;
        for(int i = 2; i < n; i++){
            int cur_i = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur_i;
        }
        return prev1;

//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i = 2; i <= n; i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n-1];

//        Recursion
//        if(n <= 1){
//            return n;
//        }
//        if(dp[n] != -1){
//            return dp[n];
//        }
//        return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
    }

    public static void print(Object obj){
        System.out.println(obj + "\n");
    }

}
